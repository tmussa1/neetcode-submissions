class Solution {
    public int minimumIndex(List<Integer> nums) {
        int [] cache = new int[nums.size()];
        Arrays.fill(cache, -1);
        int result = minIndex(nums, 0, cache);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int minIndex(List<Integer> nums, int index, int [] cache){

        if(index == nums.size()){
            return Integer.MAX_VALUE;
        }

        if(cache[index] != -1){
            return cache[index];
        }

        int result = Integer.MAX_VALUE;

        for(int i = index; i < nums.size(); i++){

            if(findMajoritySplit(nums, i)){
                result = Math.min(result, i);
            }
            result = Math.min(result, minIndex(nums, i + 1, cache));
        }

        cache[index] = result;

        return result;
    }

    private boolean findMajoritySplit(List<Integer> nums, int index){

        Map<Integer, Integer> countMap = new HashMap<>();

        int majorityCount = -1, element = -1;

        for(int j = 0; j <= index; j++){

            int num = nums.get(j);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if(countMap.get(num) > majorityCount){
                majorityCount = countMap.get(num);
                element = num;
            }
        }

        countMap = new HashMap<>();

        for(int j = index + 1; j < nums.size(); j++){

            int num = nums.get(j);

            if(num == element){
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        // System.out.println("index " + index + " count " + majorityCount + " element " + element + " size " + nums.size() + " map "+ countMap.getOrDefault(element, 0));

        if(majorityCount * 2 > (index + 1) && countMap.getOrDefault(element, 0) * 2 > (nums.size() - index - 1)){
            return true;
        }

        return false;
    }
}