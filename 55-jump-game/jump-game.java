// O(n^2) Time, O(n) Space
// class Solution {
//     private boolean canJumpFromCurrentPos(int pos, int[] nums, int[] memo) {
//         if (memo[pos] != -1) {
//             return memo[pos] == 1 ? true : false;
//         }

//         int furthestJumpIndex = Math.min(pos + nums[pos], nums.length - 1);
//         for (int i = pos + 1; i <= furthestJumpIndex; i++) {
//             if(canJumpFromCurrentPos(i, nums, memo)){
//                 memo[pos] = 1;
//                 return true;
//             }
//         }

//         memo[pos] = 0;
//         return false;
//     }

//     public boolean canJump(int[] nums) {
//         int[] memo = new int[nums.length];
//         Arrays.fill(memo, -1);
//         memo[nums.length - 1] = 1;
//         return canJumpFromCurrentPos(0, nums, memo);
//     }
// }

// O(n) Time, O(1) Space
class Solution {
    public boolean canJump(int[] nums) {
        int lastGoodPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastGoodPos) {
                lastGoodPos = i;
            }
        }
        return lastGoodPos == 0;
    }
}