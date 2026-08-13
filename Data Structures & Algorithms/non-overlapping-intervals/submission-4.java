class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int prevEnd = intervals[0][1];

        int index = 1, count = 0;

        while(index < intervals.length){

            int [] curr = intervals[index];

            if(curr[0] < prevEnd){
                count++;
                prevEnd = Math.min(prevEnd, curr[1]);
            } else {
                prevEnd = Math.max(prevEnd, curr[1]);
            }

            index++;
        }

        return count;
    }
}
