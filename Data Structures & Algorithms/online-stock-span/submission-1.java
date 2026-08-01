class StockSpanner {

    Stack<Integer> stack;
    Map<Integer, Integer> stockMap;
    int index;

    public StockSpanner() {
        this.stack = new Stack<>();
        this.stockMap = new HashMap<>();
        this.index = 0;
    }
    
    public int next(int price) {
        
        Stack<Integer> tempStack = new Stack<>();

        while(!stack.isEmpty() && stockMap.containsKey(stack.peek()) && stockMap.get(stack.peek()) <= price ) {
            tempStack.push(stack.pop());
        }

        int size = stockMap.size(), peek = stack.isEmpty() ? -1 : stack.peek();

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }

        stockMap.put(index, price);
        stack.push(index);

        this.index++;

        return size - peek;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */