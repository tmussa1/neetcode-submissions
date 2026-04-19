class Solution {

    public int longestConsecutive(int[] nums) {
        
        int length = 0;

        Set<Integer> numSet = new HashSet<>();

        for(int num: nums){
            numSet.add(num);
        }

        for(int num: nums){

            int prevNum = num - 1;

            if(!numSet.contains(prevNum)){
                int nextNum = num;
                int runningLength = 1;
                while(numSet.contains(nextNum)){
                    length = Math.max(length, runningLength++);
                    nextNum = nextNum + 1;
                }
            }
        }

        return length;
    }
}
