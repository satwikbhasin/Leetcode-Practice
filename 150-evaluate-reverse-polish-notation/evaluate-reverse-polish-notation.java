class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            } else if (token.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
           } else if (token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            } else if (token.equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1 * num2);
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }

        return stack.pop();
    }
}