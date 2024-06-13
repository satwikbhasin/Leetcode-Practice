// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         int wordCount = words.length;
//         int wordLength = words[0].length();
//         int windowSize = wordLength * wordCount;
//         HashMap<String, Integer> wordFrequency = new HashMap<>();

//         List<Integer> sol = new ArrayList<>();

//         for (String word : words) {
//             wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
//         }

//         for (int i = 0; i <= s.length() - windowSize; i++) {
//             Map<String, Integer> windowWords = new HashMap<>();
//             boolean isPossible = true;

//             for (int j = 0; j < windowSize; j += wordLength) {
//                 String currWord = s.substring(i + j, i + j + wordLength);
//                 if (!wordFrequency.containsKey(currWord)) {
//                     isPossible = false;
//                     break;
//                 }
//                 windowWords.put(currWord, windowWords.getOrDefault(currWord, 0) + 1);
//                 if (windowWords.get(currWord) > wordFrequency.get(currWord)) {
//                     isPossible = false;
//                     break;
//                 }

//             }

//             if (isPossible) {
//                 sol.add(i);
//             }

//         }

//         return sol;

//     }
// }

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> sol = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return sol;
        }

        int wordCount = words.length;
        int wordLength = words[0].length();
        int windowSize = wordLength * wordCount;

        // Create frequency map for words
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Iterate over each possible starting point in s with a sliding window
        for (int i = 0; i < wordLength; i++) {
            int left = i, count = 0;
            Map<String, Integer> seenWords = new HashMap<>();
            
            for (int right = i; right <= s.length() - wordLength; right += wordLength) {
                String word = s.substring(right, right + wordLength);
                
                if (wordFrequency.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

                    while (seenWords.get(word) > wordFrequency.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == wordCount) {
                        sol.add(left);
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return sol;
    }
}
