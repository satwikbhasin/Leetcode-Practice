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
    private void switchChildren(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // Swap the children
            switchChildren(currentNode);

            // Add children to the queue if they are not null
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }

        return root;
    }
}