class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        Map<String, Integer> cache = new HashMap<>();

        return findWays(nums, target, 0, 0, cache);
    }

    private int findWays(int [] nums, int target, int currSum, int index, Map<String, Integer> cache){

        if(index == nums.length){
            if(currSum == target){
                return 1;
            }
            return 0;
        }

        String key = index + "," + currSum;

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int add = findWays(nums, target, currSum + nums[index], index + 1, cache);
        int subtract = findWays(nums, target, currSum - nums[index], index + 1, cache);

        cache.put(key, add + subtract);

        return cache.get(key);
    }
}
