class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        return findMaxProfit(prices, 0, false, cache);
    }

    private int findMaxProfit(int[] prices, int index, boolean bought, Map<String, Integer> cache){

        if(index >= prices.length){
            return 0;
        }

        String key = index + "," + bought;

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int result = Integer.MIN_VALUE;

        if(bought){
            int sell = prices[index] + findMaxProfit(prices, index, !bought, cache);
            int skip = findMaxProfit(prices, index + 1, bought, cache);
            result = Math.max(result, Math.max(sell, skip));
        } else {
            int buy = -prices[index] + findMaxProfit(prices, index + 1, !bought, cache);
            int skip = findMaxProfit(prices, index + 1, bought, cache);
            result = Math.max(result, Math.max(buy, skip));
        }

        cache.put(key, result);

        return cache.get(key);
    }
}