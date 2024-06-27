class Solution {
    HashMap<Character, List<Character>> dictionary;
    List<String> result;

    private void initializeDictionary() {
        dictionary = new HashMap<>();
        dictionary.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        dictionary.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        dictionary.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        dictionary.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        dictionary.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        dictionary.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        dictionary.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        dictionary.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
    }

    private void dfs(int strLength, String digits, StringBuilder currString, int currLength) {
        if (currLength == strLength) {
            result.add(new String(currString.toString()));
            return;
        }

        char currNumber = digits.charAt(currLength);
        List<Character> mappings = dictionary.get(currNumber);

        for (char mapping : mappings) {
            currString.append(mapping);
            dfs(strLength, digits, currString, currLength + 1);
            currString.deleteCharAt(currString.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return result;
        }

        int strLength = digits.length();
        
        initializeDictionary();

        dfs(strLength, digits, new StringBuilder(), 0);

        return result;
    }
}