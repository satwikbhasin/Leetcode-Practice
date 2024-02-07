/**
 * Definition for a rope tree node.
 * class RopeTreeNode {
 *     int len;
 *     String val;
 *     RopeTreeNode left;
 *     RopeTreeNode right;
 *     RopeTreeNode() {}
 *     RopeTreeNode(String val) {
 *         this.len = 0;
 *         this.val = val;
 *     }
 *     RopeTreeNode(int len) {
 *         this.len = len;
 *         this.val = "";
 *     }
 *     RopeTreeNode(int len, TreeNode left, TreeNode right) {
 *         this.len = len;
 *         this.val = "";
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public char getKthCharacter(RopeTreeNode root, int k) {
        StringBuilder finalString = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        helper(root, finalString);
        return finalString.charAt(k - 1);
    }

    private void helper(RopeTreeNode root, StringBuilder finalString) {
        if (root == null) return;

        if (root.left != null) {
            helper(root.left, finalString);
        }

        finalString.append(root.val);

        if (root.right != null) {
            helper(root.right, finalString);
        }
    }
}
