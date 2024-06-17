class Solution {
    private boolean isPossible(int[] nums, int k, int possibleCapability) {
        int[] dp = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > possibleCapability) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 2] + 1, dp[i + 1]);
            }
        }
        return dp[0] >= k;
    }

    public int minCapability(int[] nums, int k) {
        // Initialize minCapability and maxCapability
        int minCapability = Integer.MAX_VALUE;
        int maxCapability = Integer.MIN_VALUE;

        // Find the minimum and maximum capability values in nums
        for (int num : nums) {
            if (num < minCapability)
                minCapability = num;
            if (num > maxCapability)
                maxCapability = num;
        }

        // Initialize min
        int min = Integer.MAX_VALUE;
        
        // Perform binary search to find the minimum capability
        while (minCapability <= maxCapability) {
            // Calculate midCapability
            int midCapability = minCapability + (maxCapability - minCapability) / 2;
            
            // Check if it's possible to rob at least k houses with midCapability
            if (isPossible(nums, k, midCapability)) {
                // Update min and adjust search range
                min = midCapability;
                maxCapability = midCapability - 1;
            } else {
                // Adjust search range
                minCapability = midCapability + 1;
            }
        }

        return min;
    }
}
