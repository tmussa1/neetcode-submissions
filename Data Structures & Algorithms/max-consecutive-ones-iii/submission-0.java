class Solution {
    public int longestOnes(int[] nums, int k) {
        
        Map<Integer, Integer> countMap = new HashMap<>();

        int left = 0, right = 0, maxWindow = 0;

        while(right < nums.length){

            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);

            while(countMap.containsKey(0) && countMap.get(0) > k){
                countMap.put(nums[left], countMap.getOrDefault(nums[left], 0) - 1);
                if(countMap.get(nums[left]) == 0){
                    countMap.remove(nums[left]);
                }
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);

            right++;
        }

        return maxWindow;
    }
}