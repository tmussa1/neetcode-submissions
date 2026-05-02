class Solution {

    class TrieNode {
        char c;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    private TrieNode root;

    private TrieNode buildNodes(String[] words){
        root = new TrieNode();
        for(String word: words){
            TrieNode curr = root;
            for(char letter: word.toCharArray()){
                if(!curr.children.containsKey(letter)){
                    curr.children.put(letter, new TrieNode());
                }
                curr = curr.children.get(letter);
            }
            curr.isWord = true;
        }
        return root;
    }

    private boolean startsWith(TrieNode root, String prefix){
        TrieNode curr = root;
        for(char letter: prefix.toCharArray()){
            if(!curr.children.containsKey(letter)){
                return false;
            }
            curr = curr.children.get(letter);
        }
        return true;
    }

    private boolean containsWord(TrieNode root, String prefix){
        TrieNode curr = root;
        for(char letter: prefix.toCharArray()){
            if(!curr.children.containsKey(letter)){
                return false;
            }
            curr = curr.children.get(letter);
        }
        return curr.isWord;
    }


    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = buildNodes(words);
        boolean [] [] visited = new boolean[board.length][board[0].length];
        Set<String> result = new HashSet<>();

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(!visited[row][col]){
                    findMatchingWords(board, root, row, col, visited, new StringBuilder(), result);
                } 
            }
        }

        return new ArrayList<>(result);
    }

    private void findMatchingWords(char[][] board, TrieNode root, 
        int row, int col, boolean [] [] visited, StringBuilder builder, 
        Set<String> result){

        if(containsWord(root, builder.toString())){
            result.add(new String(builder));
        }

        if(row < 0 || row == board.length || col < 0 || col == board[0].length
          || visited[row][col] == true || !startsWith(root, builder.toString())){
           return;
        }

        visited[row][col] = true;

        char currChar = board[row][col];

        builder.append(currChar);

        findMatchingWords(board, root, row + 1, col, visited, builder, result);
        findMatchingWords(board, root, row - 1, col, visited, builder, result);
        findMatchingWords(board, root, row, col + 1, visited, builder, result);
        findMatchingWords(board, root, row, col - 1, visited, builder, result);

        builder.deleteCharAt(builder.length() - 1);
        visited[row][col] = false;
    }
}
