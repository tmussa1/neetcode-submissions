class Solution {

    public int maxSubArray(int[] nums) {
        
        int runningSum = 0, max = Integer.MIN_VALUE;

        for(int num: nums){
            runningSum += num;
            max = Math.max(max, Math.max(num, runningSum));
            runningSum = Math.max(num, runningSum);
            System.out.println("Max " + max + " runningSum " + runningSum);
        }

        return max;
    }
}
