// O(n) Time, O(n) Space
class Solution {
    int[] dp;

    int dp(int[] nums, int currIndex, int lastIndex) {
        if (currIndex > lastIndex) {
            return 0;
        }

        if (dp[currIndex] != -1) {
            return dp[currIndex];
        }

        int includingCurr = dp(nums, currIndex + 2, lastIndex) + nums[currIndex];
        int excludingCurr = dp(nums, currIndex + 1, lastIndex);

        dp[currIndex] = Math.max(includingCurr, excludingCurr);

        return dp[currIndex];
    }

    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        dp = new int[nums.length + 1];

        Arrays.fill(dp, -1);
        int max1 = dp(nums, 0, nums.length - 2); // if you start robbing from the 1st house, you cannot rob the last house

        Arrays.fill(dp, -1);
        int max2 = dp(nums, 1, nums.length - 1); // if you start robbing from the 2nd house, you can rob the last house

        return Math.max(max1, max2);
    }
}