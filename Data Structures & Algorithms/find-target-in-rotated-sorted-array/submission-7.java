class Solution {
    public int search(int[] nums, int target) {

        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        
        int pivot = findPivot(nums);

        int left = binarySearch(nums, target, 0, pivot - 1);

        if(left != -1){
            return left;
        }

        return binarySearch(nums, target, pivot, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right){

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            } if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int findPivot(int [] nums){

        int left = 0, right = nums.length - 1;

        int result = nums.length;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(mid - 1 >= 0 && nums[mid] < nums[mid - 1]){
                result = Math.min(result, mid);
            }

            if(nums[mid] < nums[right]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
