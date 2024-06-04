class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals(t) || s.length() == 0)
            return true;
        if (s.length() > t.length()) {
            return false;
        }

        int tPointer = 0;
        int charsMatched = 0;
        for (int i = 0; i < s.length(); i++) {
            while (tPointer < t.length() && s.charAt(i) != t.charAt(tPointer)) {
                tPointer++;
            }
            if (tPointer < t.length() && s.charAt(i) == t.charAt(tPointer)) {
                charsMatched++;
            }
            if (charsMatched == s.length()) {
                return true;
            }
            tPointer++;
        }
        return false;
    }
}