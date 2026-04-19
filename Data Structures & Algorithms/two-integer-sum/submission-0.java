class Solution {

    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> indexMap = new HashMap<>();

        int [] result = new int[2];
        Arrays.fill(result, -1);

        for(int index = 0; index < nums.length; index++){
            if(indexMap.containsKey(target - nums[index])){
                result[1] = index;
                result[0] = indexMap.get(target- nums[index]);
                return result;
            }

            indexMap.put(nums[index], index);
        }

        return result;
    }
}
