import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> mappings = new HashMap<>();
        HashMap<Character, Character> reverseMappings = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if ((mappings.containsKey(sChar) && mappings.get(sChar) != tChar)
                    || (reverseMappings.containsKey(tChar) && reverseMappings.get(tChar) != sChar)) {
                return false;
            } else {
                mappings.put(sChar, tChar);
                reverseMappings.put(tChar, sChar);
            }
        }
        return true;
    }
}