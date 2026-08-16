class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        TreeMap<Integer, Integer> diffMap = new TreeMap<Integer, Integer>();

        int left = 0, right = 0, result = 0;

        while(right < nums.length){
            diffMap.put(nums[right], diffMap.getOrDefault(nums[right], 0) + 1);

            while(diffMap.lastKey() - diffMap.firstKey() > limit){
                diffMap.put(nums[left], diffMap.getOrDefault(nums[left], 0) - 1);
                if(diffMap.get(nums[left]) == 0){
                    diffMap.remove(nums[left]);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}