/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean dfs(TreeNode root, int targetSum){
        if(root.left == null && root.right == null && targetSum == 0){
            return true;
        }

        if(root.left != null){
            if(dfs(root.left, targetSum - root.left.val)){
                return true;
            }
        }

        if(root.right != null){
            if(dfs(root.right, targetSum - root.right.val)){
                return true;
            }
        }

        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum -= root.val;
        return dfs(root, targetSum);
    }
}