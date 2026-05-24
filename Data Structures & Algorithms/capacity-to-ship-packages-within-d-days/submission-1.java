class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int length = weights.length;
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        int result = Integer.MAX_VALUE;

        while(left <= right){

            int mid = left + (right - left) / 2;

            boolean canCarry = canCarryInDays(weights, mid, days);

            if(canCarry){
                right = mid - 1;
                result = Math.min(result, mid);
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canCarryInDays(int[] weights, int weight, int days){

        int currWeight = 0, index = 0, day = 1;

        while(index < weights.length){

            if(weights[index] > weight){
                return false;
            }

            currWeight += weights[index];

            if(currWeight > weight){
                day++;
                currWeight = weights[index];
            }

            index++;
        }

        return day <= days;
    }
}