class Solution {

    public int climbStairs(int n) {

        if(n < 2){
            return n;
        }
        
        int prev = 1, curr = 1, sum = 0;

        for(int i = 1; i < n; i++){
            sum = prev + curr;
            prev = curr;
            curr = sum;
        }

        return sum;
    }
}
