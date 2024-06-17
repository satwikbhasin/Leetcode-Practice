class Solution {
    int[] visited;

    private int dp(int[] nums, int currPos) {
        if (currPos >= nums.length) {
            return 0;
        }

        if (visited[currPos] != -1) {
            return visited[currPos];
        }

        int profitIncludingCurr = dp(nums, currPos + 2) + nums[currPos];
        int profitExcludingCurr = dp(nums, currPos + 1);

        int currProfit = Math.max(profitIncludingCurr, profitExcludingCurr);

        visited[currPos] = currProfit;

        return currProfit;
    }

    public int rob(int[] nums) {
        visited = new int[nums.length];
        Arrays.fill(visited, -1);
        return dp(nums, 0);
    }
}