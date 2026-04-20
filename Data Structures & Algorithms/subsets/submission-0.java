class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        generateSubsets(result, new LinkedList<Integer>(), 0, nums);

        return result;
    }

    private void generateSubsets(List<List<Integer>> result, 
        LinkedList<Integer> currList, int index, int [] nums){

        if(index == nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }

        currList.add(nums[index]);
        generateSubsets(result, currList, index + 1, nums);
        currList.removeLast();
        generateSubsets(result, currList, index + 1, nums);
    }
}
