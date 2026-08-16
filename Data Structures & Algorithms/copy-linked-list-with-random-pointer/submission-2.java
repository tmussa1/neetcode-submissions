/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> nodeMap = new HashMap<>();

        Node curr = head;

        Node dummy = new Node(-1);
        Node res = dummy;

        while(curr != null){
            Node copy = nodeMap.getOrDefault(curr, new Node(curr.val));
            nodeMap.put(curr, copy);

            if(curr.random != null){
                Node copyRandom = nodeMap.getOrDefault(curr.random, new Node(curr.random.val));
                copy.random = copyRandom;
                nodeMap.put(curr.random, copy.random);
            }
            res.next = copy;
            res = res.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
