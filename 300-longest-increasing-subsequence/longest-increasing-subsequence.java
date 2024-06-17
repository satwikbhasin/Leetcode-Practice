class Solution {
    private int dp(int[] nums, int currIndex, int[] dp) {
        if (currIndex >= nums.length) {
            return 0;
        }

        if (dp[currIndex] != 1) {
            return dp[currIndex];
        }

        int longest = 1;
        for (int nextToCurr = currIndex + 1; nextToCurr < nums.length; nextToCurr++) {
            if (nums[nextToCurr] > nums[currIndex]) {
                longest = Math.max(longest, 1 + dp(nums, nextToCurr, dp));
            }
        }

        dp[currIndex] = longest;

        return longest;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            longest = Math.max(longest, dp(nums, i, dp));
        }

        return longest;
    }
}