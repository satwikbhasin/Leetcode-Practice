class Solution {

    private boolean isPossible(int[] nums, int k, int possibleCapability) {
        int robNext = 0;
        int robNextPlusOne = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i] > possibleCapability ? robNext : robNextPlusOne + 1;

            robNextPlusOne = robNext;
            robNext = curr;
        }

        return robNext >= k;
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