class PrefixTree {

    class Node {
        Map<Character, Node> childrenMap = new HashMap<>();
        boolean isWord;
    }

    private Node root;

    public PrefixTree() {
         this.root = new Node();
    }

    public void insert(String word) {

        char [] wordArr = word.toCharArray();

        Node curr = root;

        for(char c: wordArr){

            if(!curr.childrenMap.containsKey(c)){
                curr.childrenMap.put(c, new Node());
            }

            curr = curr.childrenMap.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {

        char [] wordArr = word.toCharArray();

        Node curr = root;

        for(char c: wordArr){

            if(!curr.childrenMap.containsKey(c)){
                return false;
            }

            curr = curr.childrenMap.get(c);
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {

        char [] wordArr = prefix.toCharArray();

        Node curr = root;

        for(char c: wordArr){

            if(!curr.childrenMap.containsKey(c)){
                return false;
            }

            curr = curr.childrenMap.get(c);
        }

        return true;
    }
}
