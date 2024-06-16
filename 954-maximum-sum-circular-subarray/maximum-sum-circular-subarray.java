class Solution {
    private int kadane(int[] arr) {
        int maxSum = arr[0];
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    public int maxSubarraySumCircular(int[] nums) {

        int kadaneSum = kadane(nums);

        int[] copy = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            copy[i] = -nums[i];
        }

        int invertedKadaneSum = kadane(copy);

        int maxCircular = total + invertedKadaneSum;

        if (maxCircular == 0) {
            return kadaneSum;
        }

        return Math.max(kadaneSum, maxCircular);
    }
}