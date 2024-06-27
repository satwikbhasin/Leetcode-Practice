class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - prices[i - 1];
            if (currProfit > 0) {
                maxProfit += currProfit;
            }
        }

        return maxProfit;
    }
}