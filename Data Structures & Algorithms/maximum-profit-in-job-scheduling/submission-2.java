class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int length = startTime.length;

        int [][] times = new int [length][3];

        for(int index = 0; index < length; index++){
            times[index][0] = startTime[index];
            times[index][1] = endTime[index];
            times[index][2] = profit[index];
        }

        Arrays.sort(times, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int [] cache = new int[length + 1];

        Arrays.fill(cache, -1);

        return findMaxProfit(times, 0, cache);
    }

    private int findMaxProfit(int [][] times, int index, int [] cache){

        if(index >= times.length){
            return 0;
        }

        if(cache[index] != -1){
            return cache[index];
        }
        
        int result = 0;
        int take = times[index][2];
        int takeIndex = index;
        int takeEndTime = times[index][1];
        
        while(takeIndex < times.length && times[takeIndex][0] < takeEndTime){
            takeIndex++;
        }
        
        take += findMaxProfit(times, takeIndex, cache);

        int skip = findMaxProfit(times, index + 1, cache);

        cache[index] = Math.max(take, skip);

        return cache[index];
    }
}