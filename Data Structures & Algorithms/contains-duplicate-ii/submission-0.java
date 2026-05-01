class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> numMap = new TreeMap<>();


        for(int index = 0; index < nums.length; index++){
            if(numMap.containsKey(nums[index]) && 
                Math.abs(numMap.get(nums[index]) - index) <= k){
                    return true;
            }

            numMap.put(nums[index], index);
        }

        return false;
    }


}