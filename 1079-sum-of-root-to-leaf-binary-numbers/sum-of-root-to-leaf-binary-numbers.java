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

// S T R I N G S
// class Solution {
//     int sol = 0;
//     public int sumRootToLeaf(TreeNode root) {
//         helper(root, new String());
//         return sol;
//     }

//     private int helper(TreeNode root, String prevNumber){
//         if(root == null) return -1;
//         prevNumber = prevNumber + root.val;
//         int left = helper(root.left, prevNumber);
//         int right = helper(root.right, prevNumber);
//         if(left == -1 && right == -1){
//             sol += Integer.parseInt(prevNumber, 2);
//         }
//         return 0;
//     }
// }

// B I N A R Y   S H I F T   O P E R A T O R
class Solution {
    int sol = 0;

    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return sol;
    }

    private void helper(TreeNode root, int currNumber) {
        if (root == null) return;

        // Update the current number by shifting left and adding the current node's value
        currNumber = (currNumber << 1) | root.val;

        // If leaf node is reached, add the binary number to the result
        if (root.left == null && root.right == null) {
            sol += currNumber;
            return;
        }

        // Recursively traverse left and right subtrees
        helper(root.left, currNumber);
        helper(root.right, currNumber);
    }
}
