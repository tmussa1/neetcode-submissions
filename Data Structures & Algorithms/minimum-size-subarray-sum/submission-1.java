class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        TreeMap<Integer, Integer> prefixMap = new TreeMap<>();

        int runningSum = 0, window = Integer.MAX_VALUE;

        prefixMap.put(runningSum, -1);

        int index = 0;

        while(index < nums.length){

            runningSum += nums[index];

            prefixMap.put(runningSum, index);

            int diff = (runningSum - target);

            if(diff >= 0){
                Map.Entry<Integer, Integer> entry = prefixMap.floorEntry(diff);
                window = Math.min(window, index - entry.getValue());
            }

            index++;
            
        }

        System.out.println(prefixMap);

        return window == Integer.MAX_VALUE ? 0 : window;
    }
}