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
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        helper(root);
        int[] sol = new int[map.size()];
        int maxValue = Integer.MIN_VALUE;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                sol = new int[map.size()];
                count = 0;
                maxValue = entry.getValue();
                sol[count++] = entry.getKey();
            } else if (entry.getValue() == maxValue){
                sol[count++] = entry.getKey();
            }
        }
        return Arrays.copyOfRange(sol, 0, count);
    }

    private void helper(TreeNode root){
        if(root == null){
            return;
        }

        if(map.get(root.val) != null) {
            map.put(root.val, map.get(root.val) + 1);   
        } else {
            map.put(root.val, 1);
        }

        helper(root.left);
        helper(root.right);
        
    }
}