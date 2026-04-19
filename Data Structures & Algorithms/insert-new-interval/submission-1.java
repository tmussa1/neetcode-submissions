class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    
        int index = 0;

        List<int []> result = new ArrayList<>();

        while(index < intervals.length && intervals[index][1] < newInterval[0]){
            result.add(intervals[index++]);
        }

        int mergeStart = newInterval[0], mergeEnd = newInterval[1];

        while(index < intervals.length && intervals[index][0] <= newInterval[1]){
            mergeStart = Math.min(mergeStart, intervals[index][0]);
            mergeEnd = Math.max(mergeEnd, intervals[index++][1]);
        }

        result.add(new int [] {mergeStart, mergeEnd});

        while(index < intervals.length){
            result.add(intervals[index++]);
        }

        int [] [] resultArr = new int[result.size()][2];
        int ind = 0;

        for(int [] res: result){
            resultArr[ind++] = res;
        }

        return resultArr;
    }
}
