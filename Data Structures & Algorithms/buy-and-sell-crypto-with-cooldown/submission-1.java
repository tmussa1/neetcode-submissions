class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, false, new HashMap<String, Integer>());
    }

    public int maxProfit(int[] prices, int index, boolean bought, Map<String, Integer> cache) {

        if(index >= prices.length){
            return 0;
        }

        String key = bought + "," + index;

        if(cache.containsKey(key)){
            return cache.get(key);
        }
        
        int profit = 0;

        if(bought){
            profit = Math.max(prices[index] + maxProfit(prices, index + 2, !bought, cache),
            maxProfit(prices, index + 1, bought, cache));
        } else {
            profit = Math.max(-prices[index] + maxProfit(prices, index + 1, !bought, cache),
            maxProfit(prices, index + 1, bought, cache));
        }

        cache.put(key, profit);

        return profit;
    }
}
