class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();

        StringBuilder word = new StringBuilder();
        boolean wordEncountered = false;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar != ' ' && !wordEncountered) {
                wordEncountered = true;
            }

            if (currChar == ' ' && wordEncountered) {
                stack.push(word.toString());
                word.setLength(0);
                wordEncountered = false;
            }

            if (currChar != ' ') {
                word.append(currChar);
            }
        }

        if (wordEncountered) {
            stack.push(word.toString());
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            if (!stack.isEmpty()) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}