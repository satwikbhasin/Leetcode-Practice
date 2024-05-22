class Solution {

    private static void dfs(String s, List<String> results, StringBuilder current, int startIndex, int segmentsAdded) {
        if (startIndex == s.length() && segmentsAdded == 4) {
            results.add(current.toString());
            return;
        }

        for (int i = startIndex + 1; i <= s.length() && i <= startIndex + 3; i++) {
            String subString = s.substring(startIndex, i);
            if (isValidSubString(subString)) {
                int currentLength = current.length();
                if (currentLength != 0) {
                    current.append(".");
                }
                current.append(subString);
                dfs(s, results, current, i, segmentsAdded + 1);
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
        System.out.println("string: " + s);
        List<String> results = new ArrayList<>();
        dfs(s, results, new StringBuilder(), 0, 0);
        return results;
    }
}