class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charToWordMap = new HashMap<>();
        HashMap<String, Character> wordToCharMap = new HashMap<>();

        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        int patternPointer = 0;
        for (String word : words) {
            char patternChar = pattern.charAt(patternPointer);
            if (charToWordMap.containsKey(patternChar)) {
                if (!word.equals(charToWordMap.get(patternChar))) {
                    return false;
                }
            } else if (wordToCharMap.containsKey(word)) {
                if (patternChar != wordToCharMap.get(word)) {
                    return false;
                }
            } else {
                charToWordMap.put(patternChar, word);
                wordToCharMap.put(word, patternChar);
            }
            patternPointer++;
        }

        return true;
    }
}