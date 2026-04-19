class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));
        int [] resultArr = new int[k];

        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for(Integer key: countMap.keySet()){
            queue.add(key);
        }

        int index = 0;

        while(!queue.isEmpty() && index < k){
            resultArr[index++] = queue.poll();
        }

        return resultArr;
    }
}
