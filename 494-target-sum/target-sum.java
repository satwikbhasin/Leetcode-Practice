class Solution {
    int[] nums;
    int target;
    HashMap<String, Integer> memo;

    int[] signs = new int[] { 1, -1 };

    private int dfs(int currResult, int idx) {
        if (idx == nums.length)
            return currResult == target ? 1 : 0;

        String key = idx + "," + currResult;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int currWays = 0;
        for (int sign : signs) {
            currWays += dfs(currResult + sign * nums[idx], idx + 1);
        }

        memo.put(key, currWays);

        return memo.get(key);
    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.memo = new HashMap<>();

        return dfs(0, 0);
    }
}