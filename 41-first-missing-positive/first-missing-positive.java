class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                seen[nums[i]] = true;
            }
        }

        for (int i = 1; i < seen.length; i++) {
            if (!seen[i])
                return i;
        }

        return nums.length + 1;
    }
}