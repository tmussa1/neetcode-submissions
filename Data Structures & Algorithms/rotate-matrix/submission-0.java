class Solution {
    public void rotate(int[][] matrix) {

        int rows = matrix.length, cols = matrix[0].length;
        
        int[][] tempMatrix = new int[rows][cols];

        int col1 = cols - 1;

        for(int row = 0; row < rows; row++){
            int col = 0;
            for(int row1 = 0; row1 < rows; row1++){
                tempMatrix[row1][col1] = matrix[row][col++];
            }

            col1--;
        }

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                matrix[row][col] = tempMatrix[row][col];
            }
        }
    }
}
