class TicTacToe {


    int [] [] grid;
    int dimension;

    public TicTacToe(int n) {

        this.grid = new int[n][n];
        this.dimension = n;
    }
    
    public int move(int row, int col, int player) {
        
        this.grid[row][col] = player == 1 ? -1 : 2;

        int target1 = -1 * dimension;
        int target2 = 2 * dimension;

        if(winRow(target1) || winCol(target1) || winDiagonal(target1) 
            || winReverseDiagonal(target1)){
            return 1;
        }

        if(winRow(target2) || winCol(target2) || winDiagonal(target2) 
            || winReverseDiagonal(target2)){
            return 2;
        }

        return 0;
    }

    private boolean winRow(int target){

        for(int row = 0; row < dimension; row++){

            int sum = 0;

            for(int col = 0; col < dimension; col++){
                sum += this.grid[row][col];
            }

            if(sum == target){
                return true;
            }
        }

        return false;
    }

    private boolean winCol(int target){

        for(int col = 0; col < dimension; col++){

            int sum = 0;

            for(int row = 0; row < dimension; row++){
                sum += this.grid[row][col];
            }

            if(sum == target){
                return true;
            }
        }

        return false;
    }

    private boolean winDiagonal(int target){

        int sum = 0;

        for(int row = 0; row < dimension; row++){
            sum += this.grid[row][row];
        }

        if(sum == target){
            return true;
        }

        return false;
    }

     private boolean winReverseDiagonal(int target){

        int sum = 0;

        for(int col = 0, row = dimension - 1; col < dimension && row >= 0; col++, row--){
            sum += this.grid[row][col];
        }

        if(sum == target){
            return true;
        }

        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
