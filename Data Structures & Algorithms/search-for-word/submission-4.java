class Solution {

    public boolean exist(char[][] board, String word) {
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(findWord(board, word, row, col, 0, new HashSet<String> ())){
                    return true;
                }
            }
        }

        return false;
    }


    private boolean findWord(char[][] board, String word, int row, int col, int index, Set<String> visited){

        if(index >= word.length()){
            return true;
        }

        String key = row + "," + col;

        if(row < 0 || row == board.length || col < 0 || col == board[0].length
            || word.charAt(index) != board[row][col] || visited.contains(key)){
                return false;
        }

        visited.add(key);

        boolean result = 
                findWord(board, word, row + 1, col, index + 1, visited) || 
                findWord(board, word, row - 1, col, index + 1, visited) ||
                findWord(board, word, row, col + 1, index + 1, visited) || 
                findWord(board, word, row, col - 1, index + 1, visited);

        visited.remove(key);

        return result;
    }
}
