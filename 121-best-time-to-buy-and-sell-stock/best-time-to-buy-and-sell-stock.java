class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minValue = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minValue);
            }
        }

        return maxProfit;
    }
}