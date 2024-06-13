class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || s.length() == 0)
            return "";

        HashMap<Character, Integer> windowMap = new HashMap<>();
        HashMap<Character, Integer> tFrequency = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFrequency.put(c, tFrequency.getOrDefault(c, 0) + 1);
        }

        String sol = "";

        int required = tFrequency.size();
        int satisfied = 0;

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
                    sol = s.substring(left, right + 1);
                }

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tFrequency.containsKey(leftChar)
                        && windowMap.get(leftChar).intValue() < tFrequency.get(leftChar).intValue()) {
                    satisfied--;
                }

                left++;

            }
        }

        return sol;
    }
}