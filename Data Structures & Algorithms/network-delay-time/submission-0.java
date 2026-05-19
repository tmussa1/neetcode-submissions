class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<>();

        for(int i = 1; i <= n; i++){
            adjList.put(i, new ArrayList<>());
        }

        buildAdjList(adjList, times);

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        queue.add(new Pair<Integer, Integer>(k, 0));

        int [] timesArr = new int[n];
        Arrays.fill(timesArr, -1);

        timesArr[k - 1] = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                Pair<Integer, Integer> pair = queue.poll();

                List<Pair<Integer, Integer>> neighbors = adjList.get(pair.getKey());

                for(Pair<Integer, Integer> neighbor: neighbors){
                    int key = neighbor.getKey();
                    int val = neighbor.getValue() + pair.getValue();

                    if(timesArr[key - 1] == -1 || val < timesArr[key - 1]){
                        timesArr[key - 1] = val;
                        queue.add(new Pair<Integer, Integer>(key, val));
                    }
                }
            }
        }

        if(IntStream.of(timesArr).anyMatch(x -> x == -1)){
            return -1;
        }

        return Arrays.stream(timesArr).max().getAsInt();
    }

    private void buildAdjList(Map<Integer, List<Pair<Integer, Integer>>> adjList, int[][] times){

        for(int [] time: times){
            adjList.get(time[0]).add(new Pair<>(time[1], time[2]));
        }
    }
}
