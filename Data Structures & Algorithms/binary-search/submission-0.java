class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            int value = nums[mid];

            if(value < target){
                left = mid + 1;
            } else if(value > target){
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
