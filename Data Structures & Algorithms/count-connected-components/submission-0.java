class Solution {

    class Node {
        int val;
        int rank;
        Node parent;
    }

    public int countComponents(int n, int[][] edges) {

        Map<Integer, Node> nodeMap = new HashMap<>();

        for(int index = 0; index < n; index++){

            Node node = new Node();
            node.val = index;
            node.parent = node;

            nodeMap.put(index, node);
        }

        int connected = n;

        for(int [] edge: edges){
            Node node1 = nodeMap.get(edge[0]), node2 = nodeMap.get(edge[1]);

            connected -= link(node1, node2);
        }

        return connected;
    }

    private Node findParent(Node node){

        if(node.parent != node){
            node.parent = findParent(node.parent);
        }

        return node.parent;
    }

    private int link(Node node1, Node node2){

        node1 = findParent(node1);
        node2 = findParent(node2);

        if(node1 == node2){
            return 0;
        }

        if(node1.rank > node2.rank){
            node2.parent = node1;
        } else if(node1.rank < node2.rank){
            node1.parent = node2;
        } else {
            node2.parent = node1;
            node1.rank += 1;
        }


        return 1;
    }
}
