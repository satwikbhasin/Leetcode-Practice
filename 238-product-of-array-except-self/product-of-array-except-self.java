class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int product = 1;
        int[] solution = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                product *= nums[i];
            }
        }

        if (zeroCount > 1) {
            return solution;
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    solution[i] = product;
                    break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                solution[i] = product / nums[i];
            }
        }

        return solution;

    }
}