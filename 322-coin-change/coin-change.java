// O(n * amount) Time, O(n) Space, TOP-DOWN DP
class Solution {
    private int dp(int[] coins, int remainder, int[] dp) {
        if (remainder < 0) {
            return -1;
        }

        if (remainder == 0) {
            return 0;
        }

        if(dp[remainder - 1] != 0){
            return dp[remainder - 1];
        }

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = dp(coins, remainder - coin, dp);
            if(res >= 0 && res < min){
                min = 1 + res;
            }
        }

        dp[remainder - 1] = min == Integer.MAX_VALUE ? -1 : min;

        return dp[remainder - 1];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return dp(coins, amount, new int[amount]);
    }
}

// O(n * amount) Time, O(n) Space, BOTTOM-UP DP
// class Solution {
// public int coinChange(int[] coins, int amount) {
// if (amount < 1) {
// return 0;
// }

// int dp[] = new int[amount + 1];

// Arrays.fill(dp, Integer.MAX_VALUE);

// dp[0] = 0;
// for (int i = 1; i <= amount; i++) {
// for (int j = 0; j < coins.length; j++) {
// if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
// dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
// }
// }
// }

// return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
// }
// }