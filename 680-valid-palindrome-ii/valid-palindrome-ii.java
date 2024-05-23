class Solution {

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if (isPalindrome(s))
            return true;

        int start = 0;
        int end = s.length() - 1;

        StringBuilder sb = new StringBuilder(s);

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                if(isPalindrome(sb.deleteCharAt(start).toString())) return true;
                sb.insert(start, s.charAt(start));
                if(isPalindrome(sb.deleteCharAt(end).toString())) return true;
                return false;
            }
            start++;
            end--;
        }

        return false;
    }
}