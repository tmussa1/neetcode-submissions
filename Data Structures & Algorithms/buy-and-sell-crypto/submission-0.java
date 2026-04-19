class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;

        for(int index = 0; index < prices.length; index++){
            min = Math.min(min, prices[index]);
            profit = Math.max(profit, prices[index] - min);
        }

        return profit;
    }
}
