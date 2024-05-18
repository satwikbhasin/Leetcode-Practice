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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if(p == null || q == null) return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode tree1Node = queue1.remove();
            TreeNode tree2Node = queue2.remove();

            if (tree1Node.val != tree2Node.val) {
                return false;
            }

            if (tree1Node.left != null && tree2Node.left != null) {
                queue1.add(tree1Node.left);
                queue2.add(tree2Node.left);
            } else if (tree1Node.left != null || tree2Node.left != null) {
                return false;
            }

            if (tree1Node.right != null && tree2Node.right != null) {
                queue1.add(tree1Node.right);
                queue2.add(tree2Node.right);
            } else if (tree1Node.right != null || tree2Node.right != null) {
                return false;
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}