class Solution {
    private Map<String, Integer> memo;

    private int dfs(TreeNode node, boolean include) {
        if (node == null) {
            return 0;
        }

        String key = node + "#" + include;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int profit;
        if (include) {
            int profitIncludingCurr = node.val + dfs(node.left, false) + dfs(node.right, false);
            int profitExcludingCurr = dfs(node.left, true) + dfs(node.right, true);
            profit = Math.max(profitIncludingCurr, profitExcludingCurr);
        } else {
            int profitExcludingCurr = dfs(node.left, true) + dfs(node.right, true);
            profit = profitExcludingCurr;
        }

        // Store the result in the memoization hashmap
        memo.put(key, profit);
        return profit;
    }

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return dfs(root, true);
    }
}
