class Solution {
    int[] visited;

    private int dp(int currStep, int totalSteps) {
        if(currStep > totalSteps){
            return 0;
        }

        if (currStep == totalSteps) {
            return 1;
        }

        if(visited[currStep] != -1){
            return visited[currStep];
        }

        int totalWays = dp(currStep + 1, totalSteps) + dp(currStep + 2, totalSteps);

        visited[currStep] = totalWays;

        return totalWays;
    }

    public int climbStairs(int n) {
        visited = new int[n];
        Arrays.fill(visited, -1);
        return dp(0, n);
    }
}