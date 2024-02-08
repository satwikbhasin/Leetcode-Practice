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
        return sol;
    }

    private int helper(TreeNode root, String prevNumber){
        if(root == null) return -1;
        prevNumber = prevNumber + root.val;
        int left = helper(root.left, prevNumber);
        int right = helper(root.right, prevNumber);
        if(left == -1 && right == -1){
            sol += Integer.parseInt(prevNumber, 2);
        }
        return 0;
    }
}