class Solution {
    private boolean singleToTheLeft(int[] nums, int curr) {
        if (curr == nums.length - 1) {
            return true;
        }
        if (curr % 2 == 0) {
            return nums[curr] != nums[curr + 1];
        } else {
            return nums[curr] != nums[curr - 1];
        }
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (singleToTheLeft(nums, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[ans];
    }
}