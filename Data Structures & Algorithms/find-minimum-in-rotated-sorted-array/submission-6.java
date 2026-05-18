class Solution {
    public int findMin(int[] nums) {

        if(nums[0] <= nums[nums.length - 1]){
            return nums[0];
        }

        int pivot = findPivot(nums);

        return nums[pivot];
    }

    private int findPivot(int[] nums){

        int left = 0, right = nums.length - 1;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(mid >= 1 && nums[mid] < nums[mid - 1]){
                return mid;
            }

            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
