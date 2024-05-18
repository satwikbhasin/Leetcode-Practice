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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        if (root1 == null || root2 == null)
            return root1 == null ? root2 : root1;

        TreeNode newTree = new TreeNode(root1.val + root2.val);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        queue.add(newTree);

        while (!queue.isEmpty()) {
            TreeNode firstTreeNode = queue.remove();
            TreeNode secondTreeNode = queue.remove();
            TreeNode newTreeNode = queue.remove();

            if (firstTreeNode.left != null || secondTreeNode.left != null) {
                TreeNode firstTreeLeftNode = firstTreeNode.left != null ? firstTreeNode.left : new TreeNode();
                TreeNode secondTreeLeftNode = secondTreeNode.left != null ? secondTreeNode.left : new TreeNode();
                newTreeNode.left = new TreeNode(firstTreeLeftNode.val + secondTreeLeftNode.val);
                queue.add(firstTreeLeftNode);
                queue.add(secondTreeLeftNode);
                queue.add(newTreeNode.left);
            }

            if (firstTreeNode.right != null || secondTreeNode.right != null) {
                TreeNode firstTreeRightNode = firstTreeNode.right != null ? firstTreeNode.right : new TreeNode();
                TreeNode secondTreeRightNode = secondTreeNode.right != null ? secondTreeNode.right : new TreeNode();
                newTreeNode.right = new TreeNode(firstTreeRightNode.val + secondTreeRightNode.val);
                queue.add(firstTreeRightNode);
                queue.add(secondTreeRightNode);
                queue.add(newTreeNode.right);
            }

        }

        return newTree;
    }
}