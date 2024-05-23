import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";

        HashMap<Character, Integer> targetCount = new HashMap<>();
        HashMap<Character, Integer> windowCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int left = 0;
        int satisfied = 0;
        int target = targetCount.size();

        for (int right = 0; right < s.length(); right++) {
            char newChar = s.charAt(right);
            windowCount.put(newChar, windowCount.getOrDefault(newChar, 0) + 1);

            if (targetCount.containsKey(newChar) && windowCount.get(newChar).equals(targetCount.get(newChar))) {
                satisfied++;
            }

            while (satisfied == target) {
                int currentWindowLength = right - left + 1;
                if (currentWindowLength < minLength) {
                    minLength = currentWindowLength;
                    windowStart = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (targetCount.containsKey(leftChar) && windowCount.get(leftChar) < targetCount.get(leftChar)) {
                    satisfied--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowStart + minLength);
    }
}
