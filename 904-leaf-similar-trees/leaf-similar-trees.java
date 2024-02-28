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

    private void helper(TreeNode node, List<Integer> list) {
        if (node != null) {

            helper(node.left, list);
            helper(node.right, list);

            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            
        }
    }
}