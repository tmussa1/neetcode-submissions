class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();

        int top = 0, right = matrix[0].length, bottom = matrix.length, left = 0;

        while(left < right && top < bottom){

            for(int i = left; i < right; i++){
                result.add(matrix[top][i]);
            }

            top++;

            for(int i = top; i < bottom; i++){
                result.add(matrix[i][right - 1]);
            }

            right--;

            if(top >= bottom || left >= right){
                break;
            }

            for(int i = right - 1; i >= left; i--){
                result.add(matrix[bottom - 1][i]);
            }

            bottom--;

            for(int i = bottom - 1; i >= top; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}
