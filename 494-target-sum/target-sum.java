class Solution {
    int[] nums;
    int target;
    int ways;

    int[] signs = new int[] { 1, -1 };

    private void dfs(int currResult, int idx) {
        if (idx == nums.length) {
            if (currResult == target) {
                ways++;
            }
            return;
        }

        for (int sign : signs) {
            dfs(currResult + sign * nums[idx], idx + 1);
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.ways = 0;

        dfs(0, 0);

        return ways;
    }
}