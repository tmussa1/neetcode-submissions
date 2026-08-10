class MyCircularQueue {

    int [] queue;
    int front, rear;
    int capacity, size;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.capacity = k;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        
        if(this.size == this.capacity){
            return false;
        }

        this.queue[this.rear % this.capacity] = value;
        this.rear++;
        this.size++;

        return true;
    }
    
    public boolean deQueue() {
        
        if(this.size == 0){
            return false;
        }

        this.size--;

        this.front++;

        this.front = this.front % this.capacity;

        return true;
    }
    
    public int Front() {
        
        if(this.size == 0){
            return -1;
        }

        return this.queue[this.front];
    }
    
    public int Rear() {

        if(this.size == 0){
            return -1;
        }

        return this.queue[(this.rear - 1 + this.capacity) % this.capacity];
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */