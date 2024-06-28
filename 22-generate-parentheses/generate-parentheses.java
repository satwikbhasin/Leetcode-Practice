class Solution {
    List<String> solution;

    private void dfs(int n, int openCount, int closedCount, StringBuilder currString) {
        if (openCount == n && closedCount == n) {
            solution.add(currString.toString());
            return;
        }

        if (openCount < n) {
            currString.append('(');
            dfs(n, openCount + 1, closedCount, currString);
            currString.deleteCharAt(currString.length() - 1);
        }

        if (closedCount < openCount) {
            currString.append(')');
            dfs(n, openCount, closedCount + 1, currString);
            currString.deleteCharAt(currString.length() - 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        solution = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder());
        return solution;
    }
}