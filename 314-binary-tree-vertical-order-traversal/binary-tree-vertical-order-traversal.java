/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private void dfs(TreeNode node, Map<Integer, List<Pair<Integer, Integer>>> results, int column, int row) {
        if (node == null) {
            return;
        }

        results.putIfAbsent(column, new ArrayList<>());
        results.get(column).add(new Pair<>(row, node.val));

        dfs(node.left, results, column - 1, row + 1);
        dfs(node.right, results, column + 1, row + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Pair<Integer, Integer>>> results = new TreeMap<>();
        dfs(root, results, 0, 0);

        List<List<Integer>> finalResults = new ArrayList<>();
        for (List<Pair<Integer, Integer>> column : results.values()) {
            column.sort(Comparator.comparingInt(Pair::getKey));
            List<Integer> sortedColumn = new ArrayList<>();
            for (Pair<Integer, Integer> p : column) {
                sortedColumn.add(p.getValue());
            }
            finalResults.add(sortedColumn);
        }

        return finalResults;
    }
}