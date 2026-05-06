class Solution {
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> adjList = buildAdjList(edges, n);

        Set<Integer> visited = new HashSet<Integer>();

        for(int i = 0; i < n; i++){
            if(findCycle(adjList, i, visited, new HashSet<>(), -1) || visited.size() != n){
                return false;
            }
        }


        return true;
    }

    private boolean findCycle(Map<Integer, List<Integer>> adjList, int node, 
        Set<Integer> visited, Set<Integer> cycle, int parent){

        if(cycle.contains(node)){
            return true;
        } 

        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        cycle.add(node);

        for(Integer neighbor: adjList.get(node)){
            if(neighbor == parent) continue;
            if(findCycle(adjList, neighbor, visited, cycle, node)){
                return true;
            }
        }

        cycle.remove(node);

        return false;
    }

    Map<Integer, List<Integer>> buildAdjList(int[][] edges, int n) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int [] edge: edges){
            List<Integer> list1 = adjList.get(edge[0]);
            List<Integer> list2 = adjList.get(edge[1]);
            list1.add(edge[1]);
            list2.add(edge[0]);
            adjList.put(edge[0], list1);
            adjList.put(edge[1], list2);
        }

        return adjList;
    }
}
