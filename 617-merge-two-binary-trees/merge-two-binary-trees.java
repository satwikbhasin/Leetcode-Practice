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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode newRoot = new TreeNode();

        if(root1 == null && root2 == null)
            newRoot = null;
        else if(root1 == null && root2 != null){
            newRoot.val =  root2.val;
            newRoot.left = mergeTrees(null, root2.left);
            newRoot.right = mergeTrees(null, root2.right);        
            }
        else if(root1 != null && root2 == null){
            newRoot.val = root1.val;
            newRoot.left = mergeTrees(root1.left, null);
            newRoot.right = mergeTrees(root1.right, null); 
        }
        else{
            newRoot.val = root1.val + root2.val;
            newRoot.left = mergeTrees(root1.left, root2.left);
            newRoot.right = mergeTrees(root1.right, root2.right); 
        }

        return newRoot;
    }
}