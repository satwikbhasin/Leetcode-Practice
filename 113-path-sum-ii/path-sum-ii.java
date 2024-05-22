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
    private void dfs(TreeNode root, List<List<Integer>> results, int targetSum, List<Integer> currentNodes) {
        if (root.left == null && root.right == null && targetSum == 0) {
            results.add(new ArrayList<>(currentNodes));
            return;
        }

        if (root.left != null) {
            currentNodes.add(root.left.val);
            dfs(root.left, results, targetSum - root.left.val, currentNodes);
            currentNodes.remove(currentNodes.size() - 1);
        }

        if (root.right != null) {
            currentNodes.add(root.right.val);
            dfs(root.right, results, targetSum - root.right.val, currentNodes);
            currentNodes.remove(currentNodes.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results; 
        }
        List<Integer> currentNodes = new ArrayList<>();
        currentNodes.add(root.val);
        dfs(root, results, targetSum - root.val, currentNodes);
        return results;
    }
}