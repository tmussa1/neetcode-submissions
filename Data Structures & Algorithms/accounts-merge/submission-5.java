class Solution {

    class Node {
        int index;
        int rank;
        String email;
        Node parent;
    }

    private Node findParent(Node node){
        if(node != node.parent){
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
        } else if(node2.rank > node1.rank){
            node2.parent = node1;
        } else {
            node2.parent = node1;
            node1.rank += 1;
        }

        return 1;
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {


        Map<String, Node> emailToNodeMap = new HashMap<>();

        for(int row = 0; row < accounts.size(); row++){

            List<String> accountList = accounts.get(row);
            String firstEmail = accountList.get(1);

            Node node = new Node();
            node.email = firstEmail;
            node.index = row;
            node.parent = node;

            emailToNodeMap.putIfAbsent(firstEmail, node);

            for(int index = 2; index < accountList.size(); index++){
                Node node1 = new Node();
                node1.email = accountList.get(index);
                node1.index = row;
                node1.parent = node1;
                emailToNodeMap.putIfAbsent(node1.email, node1);
                link(findParent(emailToNodeMap.get(firstEmail)), 
                    findParent(emailToNodeMap.get(node1.email)));
            }
        }

        Map<Node, Set<String>> parentToEmailMap = new HashMap<>();

        for(Node node: emailToNodeMap.values()){
            Node node1 = findParent(node);
            parentToEmailMap.putIfAbsent(node1, new HashSet<>());
            parentToEmailMap.get(node1).add(node.email);
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<Node, Set<String>> entry: parentToEmailMap.entrySet()){
            Node node = entry.getKey();
            List<String> list = new ArrayList<>(entry.getValue());
            Collections.sort(list);
            list.add(0, accounts.get(node.index).get(0));
            result.add(list);
        }


        return result;
    }
}