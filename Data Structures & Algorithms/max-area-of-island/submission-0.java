class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    max = Math.max(max, markIslands(grid, row, col));
                }
            }
        }

        return max;
    }

    private int markIslands(int[][] grid, int row, int col){

        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length
           || grid[row][col] == 0 || grid[row][col] == -1){
            return 0;
        }

        grid[row][col] = -1;

        return 1 + markIslands(grid, row + 1, col)
                 + markIslands(grid, row - 1, col)
                 + markIslands(grid, row, col + 1)
                 + markIslands(grid, row, col - 1);
    }
}
