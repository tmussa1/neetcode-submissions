class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
            if(Math.abs(b - x) == Math.abs(a - x)){
                return b - a;
            }
            return Math.abs(b - x) - Math.abs(a - x);
        });

        for(int num: arr){

            queue.add(num);

            if(queue.size() > k){
                queue.poll();
            }
        }


        List<Integer> result = new ArrayList<>(queue);

        Collections.sort(result);

        return result;
    }
}