// O(n) Time where n is the length of substring starting from the first character of the last word to the end of the original string
// O(1) Space
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean wordEncountered = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && wordEncountered) {
                break;
            } else if (s.charAt(i) != ' ' && !wordEncountered) {
                wordEncountered = true;
            } else if (s.charAt(i) == ' ' && !wordEncountered) {
                continue;
            }
            length++;
        }
        return length;
    }
}