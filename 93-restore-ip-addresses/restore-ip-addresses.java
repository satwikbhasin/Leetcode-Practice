class Solution {

    private static void dfs(String s, List<String> results, StringBuilder current, int startIndex, int dotsAdded) {
        if (dotsAdded == 4) {
            if (startIndex == s.length()) {
                results.add(current.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length() && i < startIndex + 3; i++) {
            String subString = s.substring(startIndex, i + 1);
            if (isValidSubString(subString)) {
                int currentLength = current.length();
                if (currentLength != 0) {
                    current.append(".");
                }
                current.append(subString);
                dfs(s, results, current, i + 1, dotsAdded + 1);
                current.setLength(currentLength);
            }
        }
    }

    private static boolean isValidSubString(String subString) {
        if (subString.length() > 1 && subString.charAt(0) == '0') {
            return false;
        }
        int intValue = Integer.parseInt(subString);
        return intValue >= 0 && intValue <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        dfs(s, results, new StringBuilder(), 0, 0);
        return results;
    }
}