class Solution {

    public int numIslands(char[][] grid) {

        Set<String> visited = new HashSet<>();
        int result = 0;


        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                String location = row + "," + col;
                if(!visited.contains(location) && grid[row][col] == '1'){
                    result += 1 + findIslands(grid, row, col, visited);
                }
            }
        }
        
        return result;
    }

    private int findIslands(char[][] grid, int row, int col, Set<String> visited){

       if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0){
          return 0;
       }

       String location = row + "," + col;

       if(grid[row][col] == '0' || visited.contains(location)){
          return 0;
       }

       visited.add(location);

       int left = findIslands(grid, row + 1, col, visited);
       int right = findIslands(grid, row - 1, col, visited);
       int up = findIslands(grid, row, col + 1, visited);
       int down = findIslands(grid, row, col - 1, visited);

       return Math.max(Math.max(left, right), Math.max(up, down));
    }
}
