class Solution {
    public boolean isValidSudoku(char[][] grid) {
        
        boolean isValidBox = 
        isValidSubbox(grid, 0, 0) &&
        isValidSubbox(grid, 3, 0) &&
        isValidSubbox(grid, 6, 0) &&
        isValidSubbox(grid, 0, 3) &&
        isValidSubbox(grid, 0, 6) &&
        isValidSubbox(grid, 3, 3) &&
        isValidSubbox(grid, 3, 6) &&
        isValidSubbox(grid, 6, 3) &&
        isValidSubbox(grid, 6, 6);


        return isValidBox && isValidRow(grid) && isValidCol(grid);
    }

    private boolean isValidSubbox(char [][] grid, int startRow, int startCol){

        Set<Character> visited = new HashSet<>();

        for(int row = startRow; row < startRow + 3; row++){
         for(int col = startCol; col < startCol + 3; col++){
            if(grid[row][col] != '.' && visited.contains(grid[row][col])) {
                return false;
            }
            visited.add(grid[row][col]);
         }
       }

       return true;
    }

    private boolean isValidRow(char [][] grid){
       for(int row = 0; row < grid.length; row++){
         Set<Character> visited = new HashSet<>();
         for(int col = 0; col < grid[0].length; col++){
            if(grid[row][col] != '.' && visited.contains(grid[row][col])) {
                return false;
            }
            visited.add(grid[row][col]);
         }
       }

       return true;
    }

    private boolean isValidCol(char [][] grid){
        for(int col = 0; col < grid[0].length; col++){
            Set<Character> visited = new HashSet<>();
            for(int row = 0; row < grid.length; row++){
                if(grid[row][col] != '.' && visited.contains(grid[row][col])) {
                    return false;
                }
                visited.add(grid[row][col]);
            }
       }

       return true;
    }
}
