class Solution {
    public int maxProfit(int[] prices) {
        int minPriceTillNow = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPriceTillNow)
                minPriceTillNow = prices[i];
            else if (prices[i] - minPriceTillNow > maxProfit)
                maxProfit = prices[i] - minPriceTillNow;
        }

        return maxProfit == 0 ? 0 : maxProfit;
    }
}