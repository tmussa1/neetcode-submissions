class KthLargest {

    private PriorityQueue<Integer> queue; 
    int k;

    public KthLargest(int k, int[] nums) {

        this.queue = new PriorityQueue<Integer>((a, b) -> a - b);

        for(int num: nums){
            queue.add(num);

            if(queue.size() > k){
                queue.poll();
            }
        }

        this.k = k;
    }
    
    public int add(int val) {
        queue.add(val);

        if(queue.size() > k){
            queue.poll();
        }

        return queue.peek();
    }
}
