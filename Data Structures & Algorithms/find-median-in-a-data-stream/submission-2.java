class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
    }
    
    public void addNum(int num) {

        if(minHeap.isEmpty() || num > minHeap.peek()){
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        while(minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.poll());
        }

        while(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() * 1.0 + minHeap.peek()) / 2.0;
        }

        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }

        return minHeap.peek();
    }
}
