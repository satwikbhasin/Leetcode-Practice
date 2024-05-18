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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode leftNode = queue.remove();
            TreeNode rightNode = queue.remove();

            if (leftNode == null && rightNode == null) continue;

            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
            
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }

        return true;
    }
}