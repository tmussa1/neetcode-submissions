class Solution {

    class Node {
        int val;
        int rank;
        Node parent;
    }

    public int[] findRedundantConnection(int[][] edges) {

        Map<Integer, Node> verticesMap = new HashMap<>();
        
        for(int index = 1; index <= edges.length; index++){
            Node node = new Node();
            node.val = index;
            node.parent = node;
            verticesMap.put(index, node);
        }

        int [] result = new int[2];

        for(int [] edge: edges){

            Node node1 = verticesMap.get(edge[0]);
            Node node2 = verticesMap.get(edge[1]);

            if(!link(node1, node2)){
                result[0] = edge[0];
                result[1] = edge[1];
            }
        }

        return result;
    }

    private Node findParent(Node node){
        if(node.parent != node){
            node.parent = findParent(node.parent);
        }

        return node.parent;
    }

    private boolean link(Node node1, Node node2){

        node1 = findParent(node1);
        node2 = findParent(node2);

        if(node1 == node2){
            return false;
        }

        if(node1.rank > node2.rank){
           node2.parent = node1;
        } else if(node2.rank > node1.rank){
            node1.parent = node2;
        } else {
            node2.parent = node1;
            node1.rank += 1;
        }

        return true;
    }
}
