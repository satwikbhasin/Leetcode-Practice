// O(n) Time Complexity, O(1) Space Complexity
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}

// O(n) Time Complexity, O(n) Space Complexity
// class Solution {
// public void rotate(int[] nums, int k) {
// int[] copy = new int[nums.length];
// k = k % nums.length;
// for (int i = 0; i < nums.length; i++) {
// copy[(i + k) % nums.length] = nums[i];
// }
// for (int i = 0; i < nums.length; i++) {
// nums[i] = copy[i];
// }
// }
// }
