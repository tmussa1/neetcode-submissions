class Solution {
    public int maxProduct(int[] nums) {
        
        int runningMax = 1;
        int runningMin = 1;
        int max = Integer.MIN_VALUE;

        for(int num: nums){
            max = Math.max(Math.max(runningMin * num, max), Math.max(num, runningMax * num));
            int temp = runningMin;
            runningMin = Math.min(runningMax * num, Math.min(num, runningMin * num));
            runningMax = Math.max(temp * num, Math.max(num, runningMax * num));
        }

        return max;
    }
}
