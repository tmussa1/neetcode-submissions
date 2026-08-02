/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        int size = intervals.size();

        int [] startTimes = new int[size];
        int [] endTimes = new int[size];

        for(int i = 0; i < size; i++){
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int maxCount = 0, count = 0, startIndex = 0, endIndex = 0;

        while(startIndex < size && endIndex < size){

            if(startTimes[startIndex] < endTimes[endIndex]){
                startIndex++;
                count++;
            } else {
                endIndex++;
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
