// O(n) Time, O(n) Space, BOTTOM-UP DP
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int[] ways = new int[n];

        ways[0] = 1;
        ways[1] = 2;
        for (int i = 2; i < n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n - 1];
    }
}

// O(n) Time, O(n) Space, TOP-DOWN DP
// class Solution {
// int[] ways;
// int totalWays;

// private int dp(int n) {
// if (n == 0) {
// return 1;
// }

// if(n < 0){
// return 0;
// }

// if (ways[n] != -1) {
// return ways[n];
// }

// int waysFromHere = dp(n - 1) + dp(n - 2);

// ways[n] = waysFromHere;

// return waysFromHere;
// }

// public int climbStairs(int n) {
// totalWays = 0;
// ways = new int[n + 1];
// Arrays.fill(ways, -1);
// return dp(n);
// }
// }