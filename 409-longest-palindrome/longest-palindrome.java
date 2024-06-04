class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int palindromeLength = 0;
        boolean oddEncountered = false;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int currFrequency = entry.getValue();
            if (currFrequency % 2 == 0) {
                palindromeLength += currFrequency;
            } else {
                palindromeLength += currFrequency - 1;
                oddEncountered = true;
            }
        }

        if(oddEncountered){
            palindromeLength += 1;
        }

        return palindromeLength;
    }
}