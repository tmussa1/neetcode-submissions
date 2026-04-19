class Solution {

    public int maxSubArray(int[] nums) {
        
        int runningSum = 0, max = Integer.MIN_VALUE;

        for(int num: nums){
            runningSum += num;
            runningSum = Math.max(num, runningSum);
            max = Math.max(max, runningSum);
        }

        return max;
    }
}
