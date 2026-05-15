class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixMap = new HashMap<>();

        prefixMap.put(0, -1);

        int runningSum = 0;

        for(int index = 0; index < nums.length; index++){
            runningSum += nums[index];

            if(prefixMap.containsKey(runningSum % k)){
                if(index - prefixMap.get(runningSum % k) > 1){
                    return true;
                }
            } else {
                prefixMap.put(runningSum % k, index);
            } 
        }

        return false;
    }
}