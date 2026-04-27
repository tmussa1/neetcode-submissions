class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);

        generateSum(result, new LinkedList<Integer>(), candidates, target, 0);

        return result;
    }

    private void generateSum(List<List<Integer>> result, LinkedList<Integer> currList,
                            int[] candidates, int target, int index){

        if(target == 0){
            result.add(new ArrayList<>(currList));
            return;
        }

        if(index >= candidates.length || target < 0){
            return;
        }

        currList.add(candidates[index]);
        generateSum(result, currList, candidates, target - candidates[index], index + 1);
        currList.removeLast();


        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]){
            index++;
        }

        generateSum(result, currList, candidates, target, index + 1);

    }
}
