class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean wordEncountered = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && wordEncountered) {
                break;
            }
            if (s.charAt(i) != ' ' && !wordEncountered) {
                wordEncountered = true;
            }
            if (s.charAt(i) == ' ' && !wordEncountered) {
                continue;
            }
            length++;
        }
        return length;
    }
}