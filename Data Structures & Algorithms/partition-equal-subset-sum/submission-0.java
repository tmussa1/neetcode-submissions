class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 == 1){
            return false;
        }

        Boolean [][] cache = new Boolean[nums.length][(sum / 2) + 1];

        return canPartition(nums, sum / 2, 0, cache);
    }

    private boolean canPartition(int[] nums, int sum, int index, Boolean [][] cache){

        if(sum == 0){
            return true;
        }

        if(sum < 0 || index >= nums.length){
            return false;
        }

        if(cache[index][sum] != null){
            return cache[index][sum];
        }


        boolean take = canPartition(nums, sum - nums[index], index + 1, cache);
        boolean skip = canPartition(nums, sum, index + 1, cache);

        cache[index][sum] = take || skip;

        return cache[index][sum];
    }
}
