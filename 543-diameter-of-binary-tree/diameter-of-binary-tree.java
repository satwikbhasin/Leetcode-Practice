class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDiameter;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
