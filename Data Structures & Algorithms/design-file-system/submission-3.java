class FileSystem {

    class TrieNode {
        String dir;
        int value;
        Map<String, TrieNode> children = new HashMap<>();
    }

    private TrieNode root;

    public FileSystem() {
        this.root = new TrieNode();
    }
    
    public boolean createPath(String path, int value) {
        
        TrieNode curr = root;

        String [] pathArr = path.split("/");

        for(int index = 1; index < pathArr.length; index++){
            if(!curr.children.containsKey(pathArr[index])){
                if(index != pathArr.length - 1){
                    return false;
                }
                curr.children.put(pathArr[index], new TrieNode());
            }
            curr.dir = pathArr[index];
            curr = curr.children.get(pathArr[index]);
        }

        if(curr.value > 0){
            return false;
        }

        curr.value = value;

        return true;
    }
    
    public int get(String path) {
        TrieNode curr = root;
        String [] pathArr = path.split("/");

        for(int index = 1; index < pathArr.length; index++){
            if(!curr.children.containsKey(pathArr[index])){
                return -1;
            }
            curr = curr.children.get(pathArr[index]);
        }

        return curr.value;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
