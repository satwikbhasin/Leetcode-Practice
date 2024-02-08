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
    int sol = 0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root, new String());
        System.out.println(sol);
        return sol;
    }

    private TreeNode helper(TreeNode root, String prevNumber){
        if(root == null) return null;
        prevNumber = prevNumber + root.val;
        TreeNode left = helper(root.left, prevNumber);
        TreeNode right = helper(root.right, prevNumber);
        if(left == null && right == null){
            sol += Integer.parseInt(prevNumber, 2);
        }
        return new TreeNode();
    }
}