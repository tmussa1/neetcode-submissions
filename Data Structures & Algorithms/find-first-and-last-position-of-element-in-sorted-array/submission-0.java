class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);

        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int target, boolean findStart){

        int left = 0, right = nums.length - 1;
        int result = findStart ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] == target){

                if(findStart){
                    result = Math.min(result, mid);
                    right = mid - 1;
                } else {
                    result = Math.max(result, mid);
                    left = mid + 1;
                }
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result == Integer.MAX_VALUE || result == Integer.MIN_VALUE ? -1 : result;
    }
}