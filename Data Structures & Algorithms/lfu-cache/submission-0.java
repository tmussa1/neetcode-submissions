class LFUCache {

    class Node {

        int key;
        int value;
        Node next, prev;
        int freqCount;

        Node(int key, int value, Node next, Node prev){
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
            this.freqCount = 0;
        }
    }

    class DoublyLinkedList {

        private Map<Integer, Node> nodeMap;
        private Node left, right;

        DoublyLinkedList(){
            this.nodeMap = new HashMap<>();
            this.right = new Node(-1, -1, null, null);
            this.left = new Node(-1, -1, this.right, null);
            this.right.prev = this.left;
        }

        public void remove(Node node){
            if(node != null){
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                this.nodeMap.remove(node.key);
            }
        }

        private void pushToRight(Node node){
            Node rightPrev = this.right.prev;
            rightPrev.next = node;
            node.next = this.right;
            node.prev = rightPrev;
            this.right.prev = node;
        }

        public Node popLeft(){
            Node leftNext = this.left.next;
            remove(leftNext);
            return leftNext;
        }

        public void put(Node node){

            int key = node.key;

            if(nodeMap.containsKey(key)){
                Node node1 = nodeMap.get(key);
                remove(node1);
                pushToRight(node1);
                return;
            }

            pushToRight(node);
            nodeMap.put(key, node);
        }

        public int size() {
            return nodeMap.size();
        }
    }

    int capacity;
    Map<Integer, DoublyLinkedList> freqMap;
    Map<Integer, Node> nodeMap;
    int lfuCount = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.freqMap = new HashMap<>();
        this.nodeMap = new HashMap<>();
    }

    private void updateNodeLocation(Node node){

        if(freqMap.containsKey(node.freqCount)){

            freqMap.get(node.freqCount).remove(node);

            if(node.freqCount == lfuCount &&            freqMap.get(node.freqCount).size() == 0){
                lfuCount += 1;
            }
        }

        node.freqCount += 1;

        freqMap.putIfAbsent(node.freqCount, new DoublyLinkedList());

        freqMap.get(node.freqCount).put(node);
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }

        Node node = nodeMap.get(key);

        updateNodeLocation(node);

        return node.value;
    }
    
    public void put(int key, int value) {

        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            updateNodeLocation(node);
            return;
        }

        if(this.nodeMap.size() >= this.capacity){
            Node popped = this.freqMap.get(this.lfuCount).popLeft();
            this.nodeMap.remove(popped.key);
        }

        Node node = new Node(key, value, null, null);
        nodeMap.put(key, node);
        updateNodeLocation(node);
        this.lfuCount = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */