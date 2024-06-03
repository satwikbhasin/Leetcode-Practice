class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        for (int i = 0, j = str.length() - 1; i < str.length() && j >= 0; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}