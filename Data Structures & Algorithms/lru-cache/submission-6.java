class LRUCache {


    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    private Node head, tail;

    private int capacity, size;

    private Map<Integer, Node> nodeMap;

    public LRUCache(int capacity) {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = tail;
        this.tail.prev = head;
        this.nodeMap = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    private void removeNode(Node node){

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToLeft(Node node){

        Node nextToHead = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextToHead;
        nextToHead.prev = node;
    }
    
    public int get(int key) {
        
        Node node = nodeMap.getOrDefault(key, null);

        if(node == null){
            return -1;
        }

        removeNode(node);
        moveToLeft(node);

        return node.val;
    }
    
    public void put(int key, int value) {

        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = value;
            removeNode(node);
            moveToLeft(node);
            return;
        }

        if(this.size == this.capacity){

            Node toRemove = tail.prev;

            removeNode(toRemove);
            nodeMap.remove(toRemove.key);
            this.size--;
        }
        
        Node node = new Node(value);
        node.key = key;

        moveToLeft(node);

        nodeMap.put(key, node);

        this.size++;
    }
}
