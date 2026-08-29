class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        
        int zeroCount = 0;

        int left = 0, right = 0, window = 0;

        while(right < nums.length){

            int num = nums[right];

            if(num == 0){
                zeroCount++;
            } 

            while(zeroCount > 1 && left < nums.length){

                int leftNum = nums[left];

                if(leftNum == 0){
                    zeroCount--;
                } 

                left++;
            }

            window = Math.max(window, right - left + 1);

            right++;
        }

        return window;
    }
}
