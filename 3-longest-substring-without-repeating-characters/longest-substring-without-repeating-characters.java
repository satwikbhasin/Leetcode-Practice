class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> windowMap = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;

        while (right < s.length()) {
            char newChar = s.charAt(right);
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) + 1);

            while (windowMap.get(newChar).intValue() > 1) {
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }
}