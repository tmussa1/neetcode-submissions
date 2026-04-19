class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);


        for(int index = 0; index < nums.length; index++){

            int left = index + 1, right = nums.length - 1;
            
            while(left < right){

                int sum = nums[index] + nums[left] + nums[right];
                
                if(sum < 0){
                    left++;
                } else if(sum > 0){
                    right--;
                } else {
                    result.add(List.of(nums[index], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
