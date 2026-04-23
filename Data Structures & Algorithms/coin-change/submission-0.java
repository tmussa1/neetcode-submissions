class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] [] cache = new int[coins.length][amount + 1];

        for(int index = 0; index < coins.length; index++){
            Arrays.fill(cache[index], -1);
        }

        int result = coinChange(coins, amount, 0, cache);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int coinChange(int [] coins, int amount, int index, int [] [] cache){

        if(amount == 0){
            return 0;
        }

        if(index >= coins.length || amount < 0){
            return Integer.MAX_VALUE;
        }

        if(cache[index][amount] != -1){
          return cache[index][amount];
        }

        int result = Integer.MAX_VALUE;


        int subResult = coinChange(coins, amount - coins[index], index, cache);
        if(subResult != Integer.MAX_VALUE){
            result = Math.min(result, 1 + subResult);
        }
           
        result = Math.min(result, coinChange(coins, amount, index + 1, cache));

        cache[index][amount] = result;

        return cache[index][amount];
    }
}
