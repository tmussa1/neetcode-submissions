class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(minClimb(cost, 0, cache), minClimb(cost, 1, cache));
    }

    private int minClimb(int[] cost, int index, int [] cache){

        if(index >= cost.length){
            return 0;
        }

        if(cache[index] != -1){
            return cache[index];
        }

        int oneStep = cost[index] + minClimb(cost, index + 1, cache);
        int twoStep = cost[index] + minClimb(cost, index + 2, cache);


        cache[index] = Math.min(oneStep, twoStep);

        return cache[index];
    }
}
