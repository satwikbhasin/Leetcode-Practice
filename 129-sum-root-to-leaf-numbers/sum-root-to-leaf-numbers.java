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
    int sum;

    private void dfs(TreeNode node, StringBuilder currNum) {
        if (node == null) {
            return;
        }

        currNum.append(node.val);

        if (node.left == null && node.right == null) {
            sum += Integer.valueOf(currNum.toString());
        } else {
            dfs(node.left, currNum);
            dfs(node.right, currNum);
        }

        currNum.setLength(currNum.length() - 1);
    }

    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, new StringBuilder());
        return sum;
    }
}