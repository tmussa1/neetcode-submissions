class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixMap = new HashMap<>();

        int runningSum = 0, result = 0;

        prefixMap.put(runningSum, 1);

        for(int index = 0; index < nums.length; index++){
            runningSum += nums[index];
            if(prefixMap.containsKey(runningSum - k)){
                result += prefixMap.get(runningSum - k);
            }
            prefixMap.put(runningSum, prefixMap.getOrDefault(runningSum, 0) + 1); 
        }

        return result;
    }
 
}