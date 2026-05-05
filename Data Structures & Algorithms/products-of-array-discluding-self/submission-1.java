class Solution {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        
        int [] leftProduct = new int[length + 1];

        Arrays.fill(leftProduct, 1);

        int [] rightProduct = new int[length + 1];

        Arrays.fill(rightProduct, 1);

        int index = length - 1;

        while(index >= 0){
            rightProduct[index] = rightProduct[index + 1] * nums[index];
            index--;
        }

        index = 0;

        leftProduct[index] = nums[index++];

        while(index < length){
            leftProduct[index] = leftProduct[index - 1] * nums[index];
            index++;
        }

        int [] result = new int[length];
        result[0] = rightProduct[1];
        result[length - 1] = leftProduct[length];

        for(index = 1; index < length; index++){
            result[index] = rightProduct[index + 1] * leftProduct[index - 1];
        }

        return result;
    }
}  
