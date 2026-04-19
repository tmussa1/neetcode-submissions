class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> (int)(Math.pow(b[0], 2) + Math.pow(b[1], 2) - Math.pow(a[0], 2) - Math.pow(a[1], 2)));

        for(int [] point: points){
            queue.add(point);

            if(queue.size() > k){
                queue.poll();
            }
        }

        int [] [] result = new int [queue.size()][2];

        int index = 0;

        while(!queue.isEmpty()){
           result[index++] = queue.poll();
        }

        return result;
    }
}
