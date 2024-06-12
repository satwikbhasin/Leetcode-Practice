// O(n) Time, O(1) Space, Without using division
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];

        solution[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            solution[i] = solution[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            solution[i] = solution[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return solution;
    }
}

// O(n) Time, O(1) Space, Using division
// class Solution {
// public int[] productExceptSelf(int[] nums) {
// int zeroCount = 0;
// int product = 1;
// int[] solution = new int[nums.length];

// for (int i = 0; i < nums.length; i++) {
// if (nums[i] == 0) {
// zeroCount++;
// } else {
// product *= nums[i];
// }
// }

// if (zeroCount > 1) {
// return solution;
// }

// if (zeroCount == 1) {
// for (int i = 0; i < nums.length; i++) {
// if (nums[i] == 0) {
// solution[i] = product;
// return solution;
// }
// }
// }

// for (int i = 0; i < nums.length; i++) {
// solution[i] = product / nums[i];
// }

// return solution;

// }
// }