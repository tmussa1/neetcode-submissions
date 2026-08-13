class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> result = new HashSet<>();

        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if(countMap.get(num) > nums.length / 3){
                result.add(num);
            }
        }

        return new ArrayList<>(result);
    }
}