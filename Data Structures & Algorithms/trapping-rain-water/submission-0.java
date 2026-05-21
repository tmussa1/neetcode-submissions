class Solution {
    public int trap(int[] height) {

        int length = height.length;

        int [] leftMax = new int[length + 1];
        int [] rightMax = new int[length];

        int index = 1;
        leftMax[0] = height[0];

        while(index < length){
            leftMax[index] = Math.max(leftMax[index - 1], height[index++]);
        }

        index = length - 1;
        rightMax[index] = height[index--];

        while(index >= 0){
            rightMax[index] = Math.max(rightMax[index + 1], height[index--]);
        }

        index = 0;
        int result = 0;

        while(index < length){
            result += Math.min(leftMax[index], rightMax[index]) - height[index++];
        }

        return result;
    }
}
