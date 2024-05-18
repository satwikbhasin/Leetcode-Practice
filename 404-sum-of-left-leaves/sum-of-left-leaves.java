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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum = 0;

        while(!queue.isEmpty()){
            TreeNode currNode = queue.remove();

            if(currNode.left != null){
                queue.add(currNode.left);
                if(currNode.left.left == null && currNode.left.right == null) sum += currNode.left.val;
            }

            if(currNode.right != null){
                queue.add(currNode.right);
            }
        }

        return sum;
    }
}