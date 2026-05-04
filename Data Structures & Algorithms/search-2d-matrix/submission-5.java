class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int [] firstCol = new int[matrix.length];

        for(int index = 0; index < matrix.length; index++){
            firstCol[index] = matrix[index][0];
        }
        
        int row = findIndex(firstCol, target);

        if(row == -1){
            return false;
        }

        int col = findIndex(matrix[row], target);

         if(col == -1){
            return false;
        }

        if(matrix[row][col] == target){
            return true;
        }

        return false;
    }

    private int findIndex(int [] nums, int target){

        int left = 0, right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
