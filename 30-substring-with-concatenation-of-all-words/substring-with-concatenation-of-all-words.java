class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordsFrequency = new HashMap<>();

        List<Integer> sol = new ArrayList<>();

        int wordLength = words[0].length();
        int wordCount = words.length;
        int windowSize = wordLength * wordCount;

        if (s.length() < windowSize || s == null || s.length() == 0)
            return sol;

        for (String word : words) {
            wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            HashMap<String, Integer> seenWordsFrequency = new HashMap<>();
            int count = 0;
            int left = i;

            for (int right = i; right <= s.length() - wordLength; right += wordLength) {
                String currWord = s.substring(right, right + wordLength);
                if (wordsFrequency.containsKey(currWord)) {

                    seenWordsFrequency.put(currWord, seenWordsFrequency.getOrDefault(currWord, 0) + 1);
                    count++;

                    while (seenWordsFrequency.get(currWord) > wordsFrequency.get(currWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWordsFrequency.put(leftWord, seenWordsFrequency.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }   

                    if(count == wordCount){
                        sol.add(left);
                    }

                } else {
                    seenWordsFrequency.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return sol;

    }
}