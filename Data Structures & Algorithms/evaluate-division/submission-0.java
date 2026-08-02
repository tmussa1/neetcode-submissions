class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<String>> adjList = buildAdjList(equations);

        Map<String, Double> valueMap = new HashMap<>();

        for(int index = 0; index < equations.size(); index++){
            List<String> equation = equations.get(index);
            String eq1 = equation.get(0), eq2 = equation.get(1);

            valueMap.put(eq1 + "," + eq2, values[index]);
            valueMap.put(eq2 + "," + eq1, 1.0 / values[index]);
        }


        double [] result = new double[queries.size()];

        int index = 0;

        for(List<String> query: queries){
            String src = query.get(0), dest = query.get(1);

            if(!adjList.containsKey(src) || !adjList.containsKey(dest)){
                result[index++] = -1.0;
            } else {
                result[index++] = bfs(adjList, valueMap, src, dest);
            }
        }

        
        return result;
    }

    private double bfs(Map<String, List<String>> adjList, Map<String, Double> valueMap, String src, String dest){

        double result = 1.0;

        Queue<Pair<String, Double>> queue = new LinkedList<>();
        queue.add(new Pair<String, Double>(src, 1.0));

        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                Pair<String, Double> curr = queue.poll();
                String currKey = curr.getKey();

                visited.add(currKey);

                if(currKey.equals(dest)){
                    return curr.getValue();
                }

                List<String> neighbors = adjList.get(currKey);

                for(String neighbor: neighbors){
                    if(!visited.contains(neighbor)){
                        double value = curr.getValue() * valueMap.get(currKey + "," + neighbor);
                        queue.add(new Pair<String, Double>(neighbor, value));
                    }
                }
            }
        }

        return -1.0;
    }

    Map<String, List<String>> buildAdjList(List<List<String>> equations){

        Map<String, List<String>> adjList = new HashMap<>();

        for(List<String> equation: equations){
            String eq1 = equation.get(0), eq2 = equation.get(1);

            adjList.putIfAbsent(eq1, new ArrayList<>());
            adjList.putIfAbsent(eq2, new ArrayList<>());

            adjList.get(eq1).add(eq2);
            adjList.get(eq2).add(eq1);
        }

        return adjList;
    }
}