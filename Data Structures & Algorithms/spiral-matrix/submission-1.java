class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length, cols = matrix[0].length;

        int [] topLeft = new int [] {0, 0};
        int [] topRight = new int [] {0, cols - 1};
        int [] bottomRight = new int [] {rows - 1, cols - 1};
        int [] bottomLeft = new int [] {rows - 1, 0};

        while(result.size() < rows * cols){

            int row1 = topLeft[0], col1 = topLeft[1], col2 = topRight[1];

            while(col1 <= col2){
                result.add(matrix[row1][col1++]);
            }

            col1 = topRight[1]; row1 = topRight[0] + 1; 
            int row2 = bottomRight[0];

            while(row1 <= row2){
                result.add(matrix[row1++][col1]);
            }

            row1 = bottomRight[0]; col1 = bottomRight[1] - 1; col2 = bottomLeft[1];

            if(topLeft[0] < bottomRight[0]){
                while(col1 >= col2){
                    result.add(matrix[row1][col1--]);
                }
            }

            col1 = bottomLeft[1]; row1 = bottomLeft[0] - 1; row2 = topLeft[0];

            if(topLeft[1] < topRight[1]){
                while(row1 > row2){
                    result.add(matrix[row1--][col1]);
                }
            }

            topLeft[0] += 1;
            topLeft[1] += 1;
            topRight[0] += 1;
            topRight[1] -= 1;
            bottomRight[0] -= 1;
            bottomRight[1] -= 1;
            bottomLeft[0] -= 1;
            bottomLeft[1] += 1;
        }



        return result;
    }
}
