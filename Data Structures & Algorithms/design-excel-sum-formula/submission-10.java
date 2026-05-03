class Excel {

    class Node {
        int row;
        char col;
        int val;
        List<Node> nodes = new ArrayList<>();
    }

    Map<String, Node> nodeMap;

    public Excel(int height, char width) {

        this.nodeMap = new HashMap<>();

        for(int row = 1; row <= height; row++){
            for(char c = 'A'; c <= width; c++){
                Node node = new Node();
                node.row = row;
                node.col = c;
                node.val = 0;
                nodeMap.put(c + "" + row, node);
            }
        }
    }
    
    public void set(int row, char column, int val) {
        String key = column + "" + row;
        Node node = nodeMap.get(key);
        node.val = val;
        node.nodes = new ArrayList<>();
        nodeMap.put(key, node);
    }
    
    public int get(int row, char column) {
        String key = column + "" + row;
        Node node = nodeMap.get(key);
        int sum = findSum(node, new HashMap<>(), new HashSet<>());
        return sum;
    }
    
    public int sum(int row, char column, String[] numbers) {
        
        String key = column + "" + row;
        Node node = nodeMap.get(key);

        int sum = 0;

        List<Node> tempNodes = new ArrayList<>();

        for(String number: numbers){
             
            if(number.indexOf(":") != -1){

                String [] numberSplit = number.split(":");

                String topLeft = numberSplit[0];
                String bottomRight = numberSplit[1];

                int startRow = Integer.parseInt(topLeft.charAt(1) + ""), endRow = Integer.parseInt(bottomRight.charAt(1) + "");
                char startCol = topLeft.charAt(0);
                char endCol = bottomRight.charAt(0);

                for(int row1 = startRow; row1 <= endRow; row1++) {
                    for(char col1 = startCol; col1 <= endCol; col1++){
                        String key1 = col1 + "" + row1;
                        Node node1 = nodeMap.get(key1);
                        sum += findSum(node1, new HashMap<>(), new HashSet<>());
                        tempNodes.add(node1);
                    }
                }
            } else {
                int startRow = Integer.parseInt(number.charAt(1) + "");
                char startCol = number.charAt(0);
                String key1 = startCol + "" + startRow;
                Node node1 = nodeMap.get(key1);
                sum += findSum(node1, new HashMap<>(), new HashSet<>());
                tempNodes.add(node1);
            }
        }

        node.val = 0;
        node.nodes = tempNodes;

        nodeMap.put(column + "" + row, node);

        return sum;
    }

    private int findSum(Node node, Map<String, Integer> cache, Set<String> visiting){

        if(node == null){
            return 0;
        }

        String key = node.col + "" + node.row;

        System.out.println("Node " + node.val + " key " + key);

        if(visiting.contains(key) || cache.containsKey(key)){
            return cache.getOrDefault(key, 0);
        }

        visiting.add(key);

        int sum = node.val;

        List<Node> nodes = node.nodes;

        for(Node neighbor: nodes){
            sum += findSum(neighbor, cache, visiting);
        }

        visiting.remove(key);
        cache.put(key, sum);
    
        return sum;
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */
