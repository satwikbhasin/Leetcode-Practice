class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || s.length() == 0)
            return "";

        HashMap<Character, Integer> windowMap = new HashMap<>();
        HashMap<Character, Integer> tFrequency = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFrequency.put(c, tFrequency.getOrDefault(c, 0) + 1);
        }

        int required = tFrequency.size();
        int satisfied = 0;
        int validWindowStart = -1;

        int minLength = s.length() + 1;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char newChar = s.charAt(right);
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) + 1);

            if (tFrequency.containsKey(newChar)
                    && windowMap.get(newChar).intValue() == tFrequency.get(newChar).intValue()) {
                satisfied++;
            }

            while (left <= right && satisfied >= required) {
                char leftChar = s.charAt(left);

                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    validWindowStart = left;
                }

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }

                if (tFrequency.containsKey(leftChar)
                        && windowMap.getOrDefault(leftChar, 0) < tFrequency.get(leftChar).intValue()) {
                    satisfied--;
                }

                left++;

            }
        }

        return validWindowStart == -1 ? "" : s.substring(validWindowStart, validWindowStart + minLength);
    }
}