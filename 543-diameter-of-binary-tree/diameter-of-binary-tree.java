class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        computeDiameter(root);
        return maxDiameter;
    }

    private int computeDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = computeDiameter(node.left);
        int rightDepth = computeDiameter(node.right);

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
