class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> resultList = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int index = 0;

        while(index < intervals.length){

            int mergeStart = intervals[index][0], mergeEnd = intervals[index][1];

            while(index + 1 < intervals.length 
                    && intervals[index + 1][0] <= mergeEnd){
                mergeStart = Math.min(mergeStart, intervals[index + 1][0]);
                mergeEnd = Math.max(mergeEnd, intervals[index + 1][1]);
                index++;
            }

            resultList.add(new int[]{mergeStart, mergeEnd});

            index++;
        }

        int [] [] resultArray = new int [resultList.size()][2];

        index = 0;

        for(int [] interval: resultList){
            resultArray[index++] = interval;
        }

        return resultArray;
    }
}
