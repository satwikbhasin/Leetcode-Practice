class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        long count = 0;
        int maxCount = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int newNum = nums[right];
            if (newNum == max) {
                maxCount++;
            }
            while (maxCount == k) {
                if (nums[left] == max) {
                    maxCount--;
                }
                left++;
            }
            count += left;
        }
        return count;
    }
}