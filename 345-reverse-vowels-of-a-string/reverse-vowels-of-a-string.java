class Solution {
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        StringBuilder result = new StringBuilder(s);

        while (start < end) {
            if (!vowels.contains(s.charAt(start))) {
                start++;
            }

            if (!vowels.contains(s.charAt(end))) {
                end--;
            }

            if (vowels.contains(s.charAt(start)) && vowels.contains(s.charAt(end))) {
                char temp = s.charAt(start);
                result.setCharAt(start, s.charAt(end));
                result.setCharAt(end, temp);
                start++;
                end--;
            }
        }

        return result.toString();
    }
}