class Solution {
    public int removeElement(int[] nums, int val) {
        int invalidChanger = 0;
        for (int valFinder = 0; valFinder < nums.length; valFinder++) {
            if (nums[valFinder] != val) {
                nums[invalidChanger++] = nums[valFinder];
            }
        }

        return invalidChanger;
    }
}