class Solution {

    private int robHouses(int[] nums, int pos, int k, int possibleCapability, int[] dp) {
        if (k == 0) {
            return 0;
        }

        if (pos >= nums.length) {
            return Integer.MIN_VALUE;
        }

        if (dp[pos] != -1) {
            return dp[pos];
        }

        if (nums[pos] > possibleCapability) {
            return robHouses(nums, pos + 1, k, possibleCapability, dp);
        }

        dp[pos] = Math.max(
                1 + robHouses(nums, pos + 2, k - 1, possibleCapability, dp),
                robHouses(nums, pos + 1, k, possibleCapability, dp));

        return dp[pos];

    }

    private boolean isPossible(int[] nums, int k, int possibleCapability) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int maxRobbed = robHouses(nums, 0, k, possibleCapability, dp);
        return maxRobbed >= k;
    }

    public int minCapability(int[] nums, int k) {

        int minCapability = Integer.MAX_VALUE;
        int maxCapability = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < minCapability)
                minCapability = num;
            if (num > maxCapability)
                maxCapability = num;
        }

        int min = Integer.MAX_VALUE;
        while (minCapability <= maxCapability) {
            int midCapability = minCapability + (maxCapability - minCapability) / 2;
            if (isPossible(nums, k, midCapability)) {
                min = midCapability;
                maxCapability = midCapability - 1;
            } else {
                minCapability = midCapability + 1;
            }
        }

        return min;
    }
}