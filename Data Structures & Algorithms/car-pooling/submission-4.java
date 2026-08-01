class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a, b) -> {
            if(a[1] == b[1]){
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });
        
        PriorityQueue<int []> queue = new PriorityQueue<int []>((a, b) -> {
            if(a[2] == b[2]){
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        queue.add(trips[0]);

        int index = 1;
        long currentCap = trips[0][0];

        if(currentCap > capacity){
            return false;
        }

        while(index < trips.length){

            int [] trip = trips[index];

            while(!queue.isEmpty() && trip[1] >= queue.peek()[2]){
                int [] curr = queue.poll();
                currentCap -= curr[0];
            }

            currentCap += trip[0];

            queue.offer(trip);

            // System.out.println("Cap " + currentCap + " trip " + Arrays.toString(trip));

            if(currentCap > capacity){
                return false;
            }

            index++;
        }

        return true;
    }
}