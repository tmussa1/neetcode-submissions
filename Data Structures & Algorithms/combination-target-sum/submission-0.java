class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombination(result, new LinkedList<Integer>(), target, 0, 0, nums);
        return result;
    }

    private void generateCombination(List<List<Integer>> result, 
     LinkedList<Integer> currList, int target, int currSum, int index, int [] nums){

        if(index == nums.length || currSum > target){
            return;
        }

        if(currSum == target){
            result.add(new ArrayList<>(currList));
            return;
        }

        currList.add(nums[index]);
        generateCombination(result, currList, target, currSum + nums[index], index, nums);
        currList.removeLast();
        generateCombination(result, currList, target, currSum, index + 1, nums);
    }
}
