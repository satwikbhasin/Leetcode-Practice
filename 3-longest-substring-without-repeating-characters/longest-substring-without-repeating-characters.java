class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char newChar = s.charAt(right);
            windowCount.put(newChar, windowCount.getOrDefault(newChar, 0) + 1);
            while (windowCount.containsKey(newChar) && windowCount.get(newChar) > 1) {
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.getOrDefault(leftChar, 0) - 1);
                if (windowCount.get(leftChar) < 1) {
                    windowCount.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}