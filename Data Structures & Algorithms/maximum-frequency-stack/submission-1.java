class FreqStack {

    Map<Integer, Stack<Integer>> orderMap;
    Map<Integer, Integer> freqMap;
    PriorityQueue<Integer> queue;
    int time;

    public FreqStack() {
        this.time = 0;
        this.freqMap = new HashMap<>();
        this.orderMap = new HashMap<>();
        this.queue = new PriorityQueue<Integer>((a, b) -> {
            if(Integer.compare(freqMap.get(b), freqMap.get(a)) == 0){
                return Integer.compare(orderMap.get(b).peek(), orderMap.get(a).peek());
            }
            return Integer.compare(freqMap.get(b), freqMap.get(a));
        });
    }
    
    public void push(int val) {
      
        if(this.freqMap.containsKey(val)){
            this.queue.remove(val);
        }
        this.orderMap.putIfAbsent(val, new Stack<Integer>());
        this.orderMap.get(val).add(time);
        this.freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        this.time++;
        this.queue.offer(val);
    }
    
    public int pop() {
        if(this.queue.isEmpty()){
            return -1;
        }

        // System.out.println("Freq1 " + freqMap + " order " + orderMap);

        int val = this.queue.poll();

        this.freqMap.put(val, freqMap.getOrDefault(val, 0) - 1);
        Stack<Integer> stack = this.orderMap.get(val);
        stack.pop();

        if(this.freqMap.get(val) == 0){
            this.freqMap.remove(val);
        } else {
            queue.offer(val);
        }

        // System.out.println("Freq2 " + freqMap + " order " + orderMap + " val " + val);

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */