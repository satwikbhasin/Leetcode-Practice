class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
            } else {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}