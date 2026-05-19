class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        Map<Integer, List<Pair<Integer, Double>>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }

        buildAdjList(adjList, edges, succProb);

        PriorityQueue<Pair<Integer, Double>> queue = new PriorityQueue<Pair<Integer, Double>>((a, b) -> Double.compare(a.getValue(), b.getValue()));

        queue.add(new Pair<Integer, Double>(start_node, -1.0));

        double [] probabilities = new double[n];
        Arrays.fill(probabilities, -1);

        double result = 0.0;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                Pair<Integer, Double> pair = queue.poll();

                if(pair.getKey() == end_node){
                    result = Math.min(result, pair.getValue());
                }

                List<Pair<Integer, Double>> neighbors = adjList.get(pair.getKey());

                for(Pair<Integer, Double> neighbor: neighbors){
                    int neighborKey = neighbor.getKey();
                    double newVal = neighbor.getValue() * pair.getValue();

                    if(probabilities[neighborKey] == -1 || Double.compare(newVal, probabilities[neighborKey]) < 0){
                        queue.add(new Pair<>(neighborKey, newVal));
                        probabilities[neighborKey] = newVal;
                    }
                }
            }
        }

        return result < 0 ? result * -1.0 : 0.0;
    }

    private void buildAdjList(Map<Integer, List<Pair<Integer, Double>>> adjList, int[][] edges, double[] succProb){

        for(int index = 0; index < edges.length; index++){
            int [] edge = edges[index];
            adjList.get(edge[0]).add(new Pair<>(edge[1], succProb[index]));
            adjList.get(edge[1]).add(new Pair<>(edge[0], succProb[index]));
        }
    }
}