class Solution {
    public int minCost(int[][] costs) {
        Integer [][] cache = new Integer[costs.length][3];
        return minCost(costs, 0, -1, cache);
    }

    private int minCost(int[][] costs, int index, int prev, Integer [][] cache) {

        if(index >= costs.length){
            return 0;
        }

        if(prev >= 0 && cache[index][prev] != null){
            return cache[index][prev];
        }
        
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < 3; i++){
            if(i == prev){
                continue;
            }
            result = Math.min(result, costs[index][i] + minCost(costs, index + 1, i, cache)); 
        }

        if(prev >= 0){
            cache[index][prev] = result;
        }
        
        
        return result;
    }
}