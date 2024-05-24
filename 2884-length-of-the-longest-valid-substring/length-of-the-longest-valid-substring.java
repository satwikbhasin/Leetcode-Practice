class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbiddenSet = new HashSet<>(forbidden);

        int maxLength = 0;
        int currRight = word.length() - 1;

        for (int left = word.length() - 1; left >= 0; left--) {
            for (int right = left; right <= Math.min(left + 10, currRight); right++) {
                String check = word.substring(left, right + 1);
                if (forbiddenSet.contains(check)) {
                    currRight = right - 1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, currRight - left + 1);
        }

        return maxLength;
    }
}
