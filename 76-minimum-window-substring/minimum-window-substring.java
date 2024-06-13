class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length() || s.length() == 0)
            return "";

        HashMap<Character, Integer> windowFrequency = new HashMap<>();
        HashMap<Character, Integer> tFrequency = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFrequency.put(c, tFrequency.getOrDefault(c, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int windowStart = -1;

        int required = tFrequency.size();
        int satisfied = 0;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char newChar = s.charAt(right);
            windowFrequency.put(newChar, windowFrequency.getOrDefault(newChar, 0) + 1);

            if (tFrequency.containsKey(newChar) && windowFrequency.get(newChar).intValue() == tFrequency.get(newChar).intValue()) {
                satisfied++;
            }

            while (left <= right && satisfied >= required) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    windowStart = left;
                }
                char leftChar = s.charAt(left);
                windowFrequency.put(leftChar, windowFrequency.get(leftChar) - 1);

                if (tFrequency.containsKey(leftChar) && windowFrequency.get(leftChar) < tFrequency.get(leftChar)) {
                    satisfied--;
                }

                left++;
            }

            right++;
        }

        return windowStart == -1 ? "" : s.substring(windowStart, windowStart + minLength);
    }
}