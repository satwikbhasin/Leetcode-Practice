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
    List<Integer> sol = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        if(root == null) return null;

        List<Integer> left = getLonelyNodes(root.left);
        List<Integer> right = getLonelyNodes(root.right);

        if(left == null && right != null) sol.add(root.right.val);
        else if(left != null && right == null) sol.add(root.left.val);

        return sol;
    }
}