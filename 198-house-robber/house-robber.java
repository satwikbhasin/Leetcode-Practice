class Solution {
    int[] visited;

    private int dp(int[] nums, int currPos, int currProfit) {
        if (currPos >= nums.length) {
            return currProfit;
        }

        if (visited[currPos] != -1) {
            return visited[currPos] + currProfit;
        }

        int profitIncludingCurr = dp(nums, currPos + 2, currProfit + nums[currPos]);
        int profitExcludingCurr = dp(nums, currPos + 1, currProfit);

        int result = Math.max(profitIncludingCurr, profitExcludingCurr);

        visited[currPos] = result - currProfit;

        return result;
    }

    public int rob(int[] nums) {
        visited = new int[nums.length];
        Arrays.fill(visited, -1);
        return dp(nums, 0, 0);
    }
}