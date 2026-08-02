class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

       Arrays.sort(slots1, (a, b) -> {
         if(a[0] == b[0]){
            return a[1] - b[1];
         }
         return a[0] - b[0];
       });

       Arrays.sort(slots2, (a, b) -> {
         if(a[0] == b[0]){
            return a[1] - b[1];
         }
         return a[0] - b[0];
       });
        
       int s1Index = 0, s2Index = 0;

       while(s1Index < slots1.length && s2Index < slots2.length){
         
          int maxStart = Math.max(slots1[s1Index][0], slots2[s2Index][0]);
          int minEnd = Math.min(slots1[s1Index][1], slots2[s2Index][1]);

          if(maxStart + duration <= minEnd){
            return List.of(maxStart, maxStart + duration);
          }

          if(slots1[s1Index][1] < slots2[s2Index][1]){
            s1Index++;
          } else {
            s2Index++;
          }
       }  

       return Collections.emptyList();
    }
}
