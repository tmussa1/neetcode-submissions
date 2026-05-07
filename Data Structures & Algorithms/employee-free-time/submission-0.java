/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(List<Interval> intervals: schedule){
            for(Interval interval: intervals){
                queue.add(new int[]{interval.start, interval.end});
            }
        }

        List<Interval> mergedIntervals = new ArrayList<>();

        int [] first = queue.peek();

        int mergeStart = first[0], mergeEnd = first[1];

        while(!queue.isEmpty()){
            int [] curr = queue.poll();

            if(curr[0] <= mergeEnd && curr[0] >= mergeStart){
                mergeEnd = Math.max(mergeEnd, curr[1]);
                mergeStart = Math.min(mergeStart, curr[0]);
            } else if(curr[0] > mergeEnd){
                mergedIntervals.add(new Interval(mergeEnd, curr[0]));
                mergeEnd = Math.max(mergeEnd, curr[1]);
                mergeStart = Math.min(mergeStart, curr[0]);
            }
        }


        return mergedIntervals;
    }
}
