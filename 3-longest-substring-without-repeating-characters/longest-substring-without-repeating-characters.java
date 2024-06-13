class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        HashSet<Character> windowSet = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;

        while (right < s.length()) {
            char newChar = s.charAt(right);

            while (windowSet.contains(newChar)) {
                char leftChar = s.charAt(left);
                windowSet.remove(leftChar);
                left++;
            }

            windowSet.add(newChar);

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }
}