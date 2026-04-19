class Solution {
    public int maxArea(int[] heights) {

        int maxWater = 0;

        for(int index = 0; index < heights.length; index++){

            int left = index - 1, right = index + 1;

            while(left > 0){
                maxWater = Math.max(maxWater, Math.min(heights[index], heights[left]) * (index - left));
                left--;
            }

            while(right < heights.length){
                maxWater = Math.max(maxWater, Math.min(heights[index], heights[right]) * (right - index));
                right++;
            }
        }

        return maxWater;
    }
}
