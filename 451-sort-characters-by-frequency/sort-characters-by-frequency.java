class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((b, a) -> (a.getValue() - b.getValue()));

        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            pq.add(entry);
        }

        StringBuilder result = new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            char name = entry.getKey();
            int frequency = entry.getValue();
            for(int i = 0; i < frequency; i++){
                result.append(name);
            }
        }

        return result.toString();
    }
}