class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int maxProfit = 0;
        int peak = prices[0];
        int valley = prices[0];
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i])
                i++;
            valley = prices[i];

            while (i < prices.length - 1 && prices[i + 1] >= prices[i])
                i++;
            peak = prices[i];

            maxProfit += peak - valley;
        }

        return maxProfit;
    }
}