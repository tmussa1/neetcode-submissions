class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n, left = 0, right = n;

        int count = 1;

        while(top < bottom && left < right){

            for(int i = left; i < right; i++){
                matrix[top][i] = count++;
            }

            top++;

            for(int i = top; i < bottom; i++){
                matrix[i][right - 1] = count++;
            }

            right--;

            if(top > bottom || left > right){
                break;
            }

            for(int i = right - 1; i >= left; i--){
                matrix[bottom - 1][i] = count++;
            }

            bottom--;

            for(int i = bottom - 1; i >= top; i--){
                matrix[i][left] = count++;
            }

            left++;
        }



        return matrix;
    }
}