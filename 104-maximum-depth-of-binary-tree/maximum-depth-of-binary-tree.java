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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int currLevelSize = queue.size();

            for (int i = 0; i < currLevelSize; i++) {
                TreeNode currNode = queue.remove();
                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }
            depth++;
        }

        return depth;

    }
}