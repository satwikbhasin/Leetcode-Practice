// O(n * log m) Time, O(1) Space
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int min = 0;
        int max = minLength;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isCommonForAll(strs, mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return strs[0].substring(0, max);
    }

    private boolean isCommonForAll(String[] strs, int len) {
        String prefixCandidate = strs[0].substring(0, len);
        for (String str : strs) {
            if (!str.startsWith(prefixCandidate)) {
                return false;
            }
        }
        return true;
    }
}

// O(n * m) Time, O(1) Space
// class Solution {
// public String longestCommonPrefix(String[] strs) {

// String comparatorString = strs[0];
// int prefixEndIndex = comparatorString.length();
// for (String str : strs) {
// prefixEndIndex = Math.min(prefixEndIndex, str.length());
// for (int i = 0; i < prefixEndIndex; i++) {
// if (str.charAt(i) != comparatorString.charAt(i)) {
// prefixEndIndex = i;
// break;
// }
// }
// }

// return prefixEndIndex == -1 ? "" : comparatorString.substring(0,
// prefixEndIndex);
// }
// }