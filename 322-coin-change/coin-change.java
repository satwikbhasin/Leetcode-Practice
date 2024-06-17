class Solution {
    private int dp(int[] coins, int amountLeft, int[] count) {
        if (amountLeft < 0)
            return -1;
        if (amountLeft == 0)
            return 0;
        if (count[amountLeft - 1] != 0)
            return count[amountLeft - 1];
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = dp(coins, amountLeft - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }

        count[amountLeft - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[amountLeft - 1];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return dp(coins, amount, new int[amount]);
    }
}