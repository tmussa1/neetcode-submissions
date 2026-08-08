class SnakeGame {

    Map<String, int[]> directionMap;

    int height, width;
    int currRow, currCol;
    int snakeLength, foodIndex = 0;
    char [][] board;
    int [] [] food;

    public SnakeGame(int width, int height, int[][] food) {

        this.directionMap = Map.of("R", new int[]{0, 1}, "L", new int[]{0, -1},
        "U", new int[]{-1, 0}, "D", new int[]{1, 0});

        this.width = width + 1;
        this.height = height + 1;
        this.currRow = 0;
        this.currCol = 0;
        this.snakeLength = 0;
        this.board = new char[this.height][this.width];

        for(int row = 0; row < this.height; row++){
            Arrays.fill(this.board[row], '.');
        }

        this.board[food[0][0]][food[0][1]] = 'F';
        this.foodIndex++;
        this.food = food;

        for(int row = 0; row < this.height; row++){
            System.out.println(Arrays.toString(this.board[row]));
        }
    }
    
    public int move(String direction) {
        int [] dir = directionMap.get(direction);
        int nextRow = dir[0] + currRow, nextCol = dir[1] + currCol;
        // System.out.println("Next " + nextRow + " , " + nextCol + " height " + this.height);

        if(hitWall(nextRow, nextCol)){
            return -1;
        }

        this.currRow = nextRow;
        this.currCol = nextCol;

        if(this.board[nextRow][nextCol] == 'F'){
            this.snakeLength++;
            if(this.foodIndex < this.food.length){
                int nextFood [] = this.food[foodIndex];
                this.board[nextFood[0]][nextFood[1]] = 'F';
                this.foodIndex++;
            }
        }

        // for(int row = 0; row < this.height; row++){
        //     System.out.println(Arrays.toString(this.board[row]));
        // }

        // if(this.snakeLength == this.height){
        //     return -1;
        // }
        
        return this.snakeLength;
    }

    private boolean hitWall(int row, int col){
        return row < 0 || row >= height - 1 || col < 0 || col >= width - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
