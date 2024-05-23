class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> checkCount = new HashMap<>();
        HashMap<Character, Integer> windowCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            checkCount.put(c, checkCount.getOrDefault(c, 0) + 1);
        }

        int ogLength = s.length();
        int minLength = ogLength + 1;

        int windowStart = -1;
        int left = 0;

        int satisfied = 0;
        int required = checkCount.size();

        for (int right = 0; right < ogLength; right++) {
            char newChar = s.charAt(right);
            windowCount.put(newChar, windowCount.getOrDefault(newChar, 0) + 1);
            if (checkCount.containsKey(newChar) && checkCount.get(newChar).equals(windowCount.get(newChar))) {
                satisfied++;
            }

            while (satisfied == required) {
                int currentWindowLength = right - left + 1;
                if (currentWindowLength < minLength || (currentWindowLength == minLength && s.substring(left, right + 1)
                        .compareTo(s.substring(windowStart, windowStart + minLength)) < 0)) {
                    minLength = currentWindowLength;
                    windowStart = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (checkCount.containsKey(leftChar) && windowCount.get(leftChar) < checkCount.get(leftChar)) {
                    satisfied--;
                }
                left++;
            }
        }
        return windowStart >= 0 ? s.substring(windowStart, windowStart + minLength) : "";
    }
}