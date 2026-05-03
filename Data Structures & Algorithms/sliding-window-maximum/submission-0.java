class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Integer> indexQueue = new PriorityQueue<Integer>((a, b) -> nums[b] - nums[a]);

        int left = 0, right = 0, index = 0;

        int [] result = new int[nums.length - k + 1];

        while(right < k){
            indexQueue.add(right);
            right++;
        }

        result[index++] = nums[indexQueue.peek()];

        while(right < nums.length){
            indexQueue.add(right++);
            indexQueue.remove(left++);
            result[index++] = nums[indexQueue.peek()];
        }

        return result;
    }
}
