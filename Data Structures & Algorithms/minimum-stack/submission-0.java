class MinStack {

    private Stack<Integer> stack;
    private PriorityQueue<Integer> queue;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.queue = new PriorityQueue<Integer>();
    }
    
    public void push(int val) {
        stack.add(val);
        queue.add(val);
    }
    
    public void pop() {
        int val = stack.pop();
        queue.remove(val);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return queue.peek();
    }
}
