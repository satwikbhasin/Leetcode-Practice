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
    List<Integer> leafs1 = new ArrayList<>();
    List<Integer> leafs2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        helper(root1, leafs1);
        helper(root2, leafs2);
        return leafs1.equals(leafs2);
    }

    private Integer helper(TreeNode node, List<Integer> list) {
        if (node == null)
            return null;

        Integer leftChild = helper(node.left, list);
        Integer rightChild = helper(node.right, list);

        if (leftChild == null && rightChild == null) {
            list.add(node.val);
        }

        return 1;
    }
}