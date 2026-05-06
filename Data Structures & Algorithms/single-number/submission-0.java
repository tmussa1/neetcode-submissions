class Solution {
    public int singleNumber(int[] nums) {
        
        int xor = 1;

        for(int num: nums){
            xor ^= num;
        }

        return xor ^ 1;
    }
}
