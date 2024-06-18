class Solution {
    public boolean isValid(String s) {
        HashSet<Character> openingBrackets = new HashSet<>();
        openingBrackets.add('(');
        openingBrackets.add('{');
        openingBrackets.add('[');
        HashSet<Character> closingBrackets = new HashSet<>();
        closingBrackets.add(')');
        closingBrackets.add('}');
        closingBrackets.add(']');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (openingBrackets.contains(c))
                stack.push(c);
            else if (closingBrackets.contains(c)) {
                if(stack.isEmpty()) return false;
                if (c == ')' && stack.pop() != '(')
                    return false;
                else if (c == '}' && stack.pop() != '{')
                    return false;
                else if (c == ']' && stack.pop() != '[')
                    return false;
            }

        }

        return stack.isEmpty();
    }
}