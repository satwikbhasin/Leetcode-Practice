// O(n * logn) Time, O(n) Space
class Solution {
    private int binarySearch(List<Integer> subList, int curr) {
        int left = 0;
        int right = subList.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (subList.get(mid) > curr) {
                right = mid;
            } else if (subList.get(mid) < curr) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> subList = new ArrayList<>();
        subList.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > subList.get(subList.size() - 1)) {
                subList.add(nums[i]);
            } else {
                int indexToChange = binarySearch(subList, nums[i]);
                subList.set(indexToChange, nums[i]);
            }
        }

        return subList.size();
    }
}

// O(n^2) Time, O(n) Space
// class Solution {
// private int dp(int[] nums, int currIndex, int[] dp) {
// if (currIndex >= nums.length) {
// return 0;
// }

// if (dp[currIndex] != 1) {
// return dp[currIndex];
// }

// int longest = 1;
// for (int nextToCurr = currIndex + 1; nextToCurr < nums.length; nextToCurr++)
// {
// if (nums[nextToCurr] > nums[currIndex]) {
// longest = Math.max(longest, 1 + dp(nums, nextToCurr, dp));
// }
// }

// dp[currIndex] = longest;

// return longest;
// }

// public int lengthOfLIS(int[] nums) {
// int[] dp = new int[nums.length];
// Arrays.fill(dp, 1);
// int longest = 0;
// for (int i = 0; i < nums.length; i++) {
// longest = Math.max(longest, dp(nums, i, dp));
// }

// return longest;
// }
// }