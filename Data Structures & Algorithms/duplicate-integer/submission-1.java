class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> numMap = new HashMap<>();

        for(int num: nums){
            if(numMap.containsKey(num)){
                return true;
            }

            numMap.put(num, true);
        }

        return false;
    }
}