class Solution {
    public int change(int amount, int[] coins) {
        int [][]  cache = new int[coins.length][amount + 1];

        for(int index = 0; index < coins.length; index++){
            Arrays.fill(cache[index], -1);
        }
        return coinChange(amount, coins, 0, cache);
    }

    private int coinChange(int amount, int[] coins, int index, int [][] cache){

        if(index >= coins.length){
            if(amount == 0){
                return 1;
            }
            return 0;
        }

        if(amount < 0){
            return 0;
        }

        if(amount == 0){
            return 1;
        }

        if(cache[index][amount] != -1){
            return cache[index][amount];
        }

        int result = 0;

        for(int i = index; i < coins.length; i++){
            result += coinChange(amount - coins[i], coins, i, cache);
        }

        cache[index][amount] = result;

        return result;
    }
}
