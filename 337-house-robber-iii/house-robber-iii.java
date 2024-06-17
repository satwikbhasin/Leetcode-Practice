// O(n) Time, O(n) Space
class Solution {
    class NodeKey {
        TreeNode node;
        boolean isIncluded;

        public NodeKey(TreeNode node, boolean isIncluded) {
            this.node = node;
            this.isIncluded = isIncluded;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            NodeKey nodeKey = (NodeKey) o;
            return isIncluded == nodeKey.isIncluded && Objects.equals(node, nodeKey.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, isIncluded);
        }
    }

    private Map<NodeKey, Integer> memo;

    private int dfs(TreeNode node, boolean include) {
        if (node == null) {
            return 0;
        }

        NodeKey key = new NodeKey(node, include);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int profit = 0;
        if (include) {
            int profitIncludingCurr = node.val + dfs(node.left, false) + dfs(node.right, false);
            int profitExcludingCurr = dfs(node.left, true) + dfs(node.right, true);
            profit = Math.max(profitIncludingCurr, profitExcludingCurr);
        } else {
            profit = dfs(node.left, true) + dfs(node.right, true);
        }

        memo.put(key, profit);
        return profit;
    }

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return dfs(root, true);
    }
}