class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Map.Entry<Integer, Integer>>> adjList = buildAdjList(n, flights);

        List<Map.Entry<Integer, Integer>> srcList = adjList.get(src);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(Map.Entry<Integer, Integer> entry: srcList){
            queue.add(new int [] {entry.getKey(), entry.getValue(), 0});
        }

        int result = Integer.MAX_VALUE;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int [] curr = queue.poll();

                if(curr[2] > k) continue;

                if(curr[0] == dst){
                    result = Math.min(result, curr[1]);
                }

                List<Map.Entry<Integer, Integer>> nextList = adjList.get(curr[0]);

                for(Map.Entry<Integer, Integer> entry: nextList){
                    if(entry.getValue() + curr[1] > result) continue;
 
                    queue.add(new int [] {
                        entry.getKey(),
                        entry.getValue() + curr[1],
                        curr[2] + 1
                    });
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    Map<Integer, List<Map.Entry<Integer, Integer>>> buildAdjList(int n, int[][] flights){

        Map<Integer, List<Map.Entry<Integer, Integer>>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int [] flight: flights){

            int src = flight[0], dest = flight[1], cost = flight[2];

            List<Map.Entry<Integer, Integer>> list = adjList.get(src);
            list.add(Map.entry(dest, cost));

            adjList.put(src, list);
        }

        return adjList;
    }
}
