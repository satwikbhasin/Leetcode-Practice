class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0;
        int left = 0, right = 0;

        int minLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            windowSum += nums[right];

            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= nums[left];
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}