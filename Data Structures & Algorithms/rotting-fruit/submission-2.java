class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 2){
                    queue.add(new int[] {row, col});
                }
            }
        }

        if(queue.isEmpty()){
            for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                   return -1;
                }
            }
        }
            return 0;
        }


        int time = -1;

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i < size; i++){

                int [] coordinate = queue.poll();
                int [] [] nextGrid = new int [] [] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                for(int [] nextEntry: nextGrid){
                    int nextRow = nextEntry[0] + coordinate[0];
                    int nextCol = nextEntry[1] + coordinate[1];
                    if(isInBounds(grid, nextRow, nextCol)){
                        if(grid[nextRow][nextCol] == 1) {
                            grid[nextRow][nextCol] = 2;
                            queue.add(new int[]{nextRow, nextCol});
                        }
                    }
                }

            }

            time++;
        }

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                   return -1;
                }
            }
        }

        return time;
    }

    private boolean isInBounds(int[][] grid, int nextRow, int nextCol){
        if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length){
            return false;
        }
        return true;
    }
}
