class Solution {


    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> prefixMap = new HashMap<>();

        int runningSum = 0;

        prefixMap.put(0, 1);

        int result = 0;

        for(int index = 0; index < nums.length; index++){

            runningSum += nums[index];

            int prefix = ((runningSum % k) + k) % k;

            if(prefixMap.containsKey(prefix)){
                result += prefixMap.get(prefix);
            }

            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);
        }

        return result;
    }

    // 0, -2, -3, -1, 0
    // 0, 0, 1, 1, 0
}