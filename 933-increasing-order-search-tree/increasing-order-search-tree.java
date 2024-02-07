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
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> inorderPath = new ArrayList<TreeNode>();

        inorder(root, inorderPath);

        TreeNode current = new TreeNode(0);
        TreeNode copyOfAnswer = current;
        for (TreeNode node : inorderPath) {
            current.right = new TreeNode(node.val);
            current = current.right;
        }

        return copyOfAnswer.right;
    }

    private TreeNode inorder(TreeNode node, List<TreeNode> sol){
        if(node == null) return null;

        TreeNode nodeLeft = inorder(node.left, sol);
        sol.add(node);
        TreeNode nodeRight = inorder(node.right, sol);

        return null;
    }
}