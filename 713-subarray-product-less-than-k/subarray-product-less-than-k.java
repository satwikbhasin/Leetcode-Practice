class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int left = 0;

        int windowProduct = 1;

        for (int right = 0; right < nums.length; right++) {
            windowProduct *= nums[right];
            while (left <= right && windowProduct >= k) {
                windowProduct = windowProduct / nums[left];
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }
}