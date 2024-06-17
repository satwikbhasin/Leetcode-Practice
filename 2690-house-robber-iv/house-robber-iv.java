class Solution {

    private int robHouses(int[] nums, int pos, int k, int possibleCapability, int[] dp) {
        // Base case: if we have robbed k houses consecutively
        if (k == 0) {
            return 0;
        }

        if(pos >= nums.length){
            return 0;
        }

        if (dp[pos] != -1) {
            return dp[pos];
        }

        // Base case: if we reached the end of the array
        if (pos >= nums.length) {
            return Integer.MIN_VALUE; // Return a negative value indicating that it's not possible to rob k houses
        }

        // If the current house exceeds the possible capability, skip it
        if (nums[pos] > possibleCapability) {
            return robHouses(nums, pos + 1, k, possibleCapability, dp);
        }

        // Recursive case:
        // 1. Rob the current house and continue robbing k - 1 houses starting from two
        // positions ahead
        // 2. Skip the current house and continue robbing k houses starting from the
        // next position
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