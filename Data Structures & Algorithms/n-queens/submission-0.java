class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char [] [] board = new char[n][n];

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                board[row][col] = '.';
            }
        }

        backtrack(result, board, 0, n);

        return result;
    }

    private void backtrack(List<List<String>> result, char [] [] board,
        int row, int n){

        if(row == n){
            result.add(Arrays.stream(board).map(String::new).collect(Collectors.toList()));
            return;
        }

        for(int col = 0; col < n; col++){
            if(canPlaceQueen(board, row, col, n)){
                char temp = board[row][col];
                board[row][col] = 'Q';
                backtrack(result, board, row + 1,  n);
                board[row][col] = temp;
            }
        }
    }

    private boolean canPlaceQueen(char [] [] board, int row, int col, int n){

        boolean canPlace = true;

        for(int c = 0; c < n; c++){
            if(board[row][c] == 'Q'){
                canPlace = false;
            }
        }

        for(int r = 0; r < n; r++){
            if(board[r][col] == 'Q'){
                canPlace = false;
            }
        }

        for(int r = row, c = col; r >= 0 && c >= 0; r--, c--){
            if(board[r][c] == 'Q'){
                canPlace = false;
            }
        }

         for(int r = row, c = col; r >= 0 && c < n; r--, c++){
            if(board[r][c] == 'Q'){
                canPlace = false;
            }
        }

        return canPlace;
    }
}
