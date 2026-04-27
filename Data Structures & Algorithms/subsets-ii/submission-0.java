class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        generateSubsets(result, new LinkedList<Integer>(), nums, 0);

        return new ArrayList<>(result);
    }

    private void generateSubsets(Set<List<Integer>> result,
                                LinkedList<Integer> currList,
                                int[] nums, int index){

        if(index == nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }

        currList.add(nums[index]);
        generateSubsets(result, currList, nums, index + 1);
        currList.removeLast();
        generateSubsets(result, currList, nums, index + 1);
    }
}
