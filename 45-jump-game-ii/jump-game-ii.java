// O(n) Time, O(1) Space
// class Solution {
//     public int jump(int[] nums) {
//         int minJumps = 0;
//         int currentJumpsFarthest = 0;
//         int currentJumpsEnd = 0;

//         for (int i = 0; i < nums.length - 1; i++) {
//             currentJumpsFarthest = Math.max(currentJumpsFarthest, i + nums[i]);

//             if (i == currentJumpsEnd) {
//                 minJumps++;
//                 currentJumpsEnd = currentJumpsFarthest;

//                 if (currentJumpsEnd >= nums.length - 1)
//                     break;
//             }
//         }

//         return minJumps;
//     }
// }

// O(n^2) Time, O(1) Space
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[nums.length - 1];
    }
}