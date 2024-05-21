class Solution {
    public class CharacterData {
        char name;
        int count;

        public CharacterData(char name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        PriorityQueue<CharacterData> pq = new PriorityQueue<>((a, b) -> (b.count - a.count));

        for (char c : s.toCharArray()) {
            if (!charCount.containsKey(c)) {
                charCount.put(c, 0);
            }
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> charData : charCount.entrySet()) {
            pq.add(new CharacterData(charData.getKey(), charData.getValue()));
        }

        if(pq.peek().count > (s.length()+1)/2) return "";

        char[] result = new char[s.length()];

        int pointer = 0;
        while (!pq.isEmpty()) {
            CharacterData currChar = pq.poll();
            int count = currChar.count;
            char character = currChar.name;
            for (int i = 0; i < count; i++) {
                result[pointer] = character;
                pointer += 2;
                if (pointer >= s.length())
                    pointer = 1;
            }
        }

        return new String(result);
    }
}