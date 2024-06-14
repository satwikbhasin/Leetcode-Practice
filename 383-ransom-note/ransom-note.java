// O(m + n) Time, O(m) Space where m is the length of magazine and n is the length of ransom note
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        HashMap<Character, Integer> magazineFrequency = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineFrequency.put(c, magazineFrequency.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (magazineFrequency.containsKey(c)) {
                if (magazineFrequency.get(c) < 1) {
                    return false;
                }
                magazineFrequency.put(c, magazineFrequency.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}