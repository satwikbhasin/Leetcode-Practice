class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            while (set.contains(currChar)) {
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }
            set.add(currChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}