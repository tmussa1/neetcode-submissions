class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        TreeMap<Integer, Integer> indexMap = new TreeMap<>();
        
        for(int index = 0; index < days.length; index++){
            indexMap.put(days[index], index);
        }

        int [] durations = new int[]{1, 7, 30};

        Map<Integer, Integer> cache = new HashMap<>();

        return findMinCost(indexMap, days, costs, 0, durations, cache);
    }

    private int findMinCost(TreeMap<Integer, Integer> indexMap, int[] days, int[] costs, 
        int index, int [] durations, Map<Integer, Integer> cache){

        if(index >= days.length){
            return 0;
        }

        if(cache.containsKey(index)){
            return cache.get(index);
        }

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < costs.length; i++){
           int cost = costs[i];
           int duration = durations[i];
           Map.Entry<Integer, Integer> entry = indexMap.ceilingEntry(days[index] + duration);

           if(entry == null){
              result = Math.min(result, cost);
           } else {
              result = Math.min(result, cost + findMinCost(indexMap, days, costs, entry.getValue(), durations, cache));
           }
        } 

        cache.put(index, result);

        return result;   
    }
}