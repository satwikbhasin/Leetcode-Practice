class Solution {
    public String longestCommonPrefix(String[] strs) {

        String comparatorString = strs[0];
        int prefixEndIndex = comparatorString.length();
        for (String str : strs) {
            prefixEndIndex = Math.min(prefixEndIndex, str.length());
            for (int i = 0; i < prefixEndIndex; i++) {
                if (str.charAt(i) != comparatorString.charAt(i)) {
                    prefixEndIndex = i;
                    break;
                }
            }
        }

        return prefixEndIndex == -1 ? "" : comparatorString.substring(0, prefixEndIndex);
    }
}