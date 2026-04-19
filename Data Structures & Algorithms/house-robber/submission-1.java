class Solution {

    public int rob(int[] nums) {
        
        int [] cache = new int[nums.length];
        Arrays.fill(cache, -1);

        return simulateRobbing(nums, 0, cache);
    }

    private int simulateRobbing(int [] nums, int index, int [] cache){

        if(index >= nums.length){
            return 0;
        }

        if(cache[index] != -1){
            return cache[index];
        }

        int rob = nums[index] + simulateRobbing(nums, index + 2, cache);
        int skip = simulateRobbing(nums, index + 1, cache);

        cache[index] = Math.max(rob, skip);

        return cache[index];
    }
}
