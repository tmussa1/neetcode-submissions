class Solution {
    public void rotate(int[] nums, int k) {
        
        int length = nums.length;

        k = k % length;

        swap(nums, 0, length - 1);
        swap(nums, k, length - 1);
        swap(nums, 0, k - 1);
    }

    private void swap(int[] nums, int left, int right){

        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
        }
    }
}