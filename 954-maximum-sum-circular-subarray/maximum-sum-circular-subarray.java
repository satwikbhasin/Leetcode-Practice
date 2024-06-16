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

    private int minKadane(int[] arr) {
        int minSum = arr[0];
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            minSum = Math.min(minSum, currSum);

            if (currSum > 0) {
                currSum = 0;
            }
        }

        return minSum;
    }

    public int maxSubarraySumCircular(int[] nums) {

        int kadaneSum = kadane(nums);

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int minKadaneSum = minKadane(nums);

        int maxCircular = total - minKadaneSum;

        if (maxCircular == 0) {
            return kadaneSum;
        }

        return Math.max(kadaneSum, maxCircular);
    }
}