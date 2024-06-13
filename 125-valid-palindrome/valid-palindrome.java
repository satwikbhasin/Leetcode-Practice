class Solution {
    private boolean isLetterOrDigit(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            while (left <= right && !isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left <= right && !isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left <= right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}