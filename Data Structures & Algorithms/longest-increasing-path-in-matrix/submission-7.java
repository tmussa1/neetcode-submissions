class Solution {

    public int longestIncreasingPath(int[][] matrix) {

        int [][] visited = new int[matrix.length][matrix[0].length];
        for(int row = 0; row < matrix.length;  row++){
            Arrays.fill(visited[row], -1);
        }

        int result = 0;
        
        for(int row = 0; row < matrix.length;  row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(visited[row][col] == -1){
                    result = Math.max(result, findPath(matrix, row, col, visited, Integer.MIN_VALUE));
                }
            }
        }

        return result;
    }

    private int findPath(int[][] matrix, int row, int col, int [] [] visited, int prevVal){

        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
            || matrix[row][col] <= prevVal){
            return 0;
        }

        if(visited[row][col] != -1){
            return visited[row][col];
        }

        int result = 1;

        int down = findPath(matrix, row + 1, col, visited, matrix[row][col]);
        int right = findPath(matrix, row, col + 1, visited, matrix[row][col]);
        int up = findPath(matrix, row - 1, col, visited, matrix[row][col]);
        int left = findPath(matrix, row, col - 1, visited, matrix[row][col]);
     
        result = Math.max(result, 1 + Math.max(Math.max(left, right), Math.max(up, down)));

        visited[row][col] = result;

        return visited[row][col];
    }
}
