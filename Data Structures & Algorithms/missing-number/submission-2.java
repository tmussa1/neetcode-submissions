class Solution {

    public int missingNumber(int[] nums) {
        
        int num = 0, xor = 1, max = Integer.MIN_VALUE;

        for(int num1: nums){
           max = Math.max(max, num1);
        }

        if(max == nums.length - 1){
            max = nums.length;
        }

        while(num <= max){
            xor ^= num;
            num++;
        }

        for(int num1: nums){
            xor ^= num1;
        }

        return xor ^ 1;
    }
}
