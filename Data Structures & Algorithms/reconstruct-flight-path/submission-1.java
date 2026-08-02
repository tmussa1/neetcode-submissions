class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, Integer> visitedMap = new HashMap<>();

        Map<String, List<String>> adjList = buildAdjList(tickets, visitedMap);

        System.out.println(adjList);

        List<String> result = new ArrayList<>();

        dfs(adjList, "JFK", result, tickets.size(), visitedMap, new HashSet<String>());

        return result;
    }

    private boolean dfs(Map<String, List<String>> adjList, String node, List<String> path, int ticketCount, Map<String, Integer> visited, Set<String> cache){

        path.add(node);
        cache.add(node);

        if(path.size() == ticketCount + 1){
            return true;
        }

        for(String neighbor: adjList.get(node)){
            String key = node + "," + neighbor;
            if(visited.get(key) > 0){
                visited.put(key, visited.get(key) - 1);
                if(dfs(adjList, neighbor, path, ticketCount, visited, cache)) {
                    return true;
                }
                visited.put(key, visited.get(key) + 1);
            }
        }

        path.remove(path.size() - 1);

        return false;
    }

    Map<String, List<String>> buildAdjList(List<List<String>> tickets, Map<String, Integer> visitedMap){

        Map<String, List<String>> adjList = new HashMap<>();

        for(List<String> ticket: tickets){
            String src = ticket.get(0), dest = ticket.get(1);
            String key = src + "," + dest;
            visitedMap.put(key, visitedMap.getOrDefault(key, 0) + 1);

            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.putIfAbsent(dest, new ArrayList<>());

            adjList.get(src).add(dest);
        }

        for(Map.Entry<String, List<String>> entry: adjList.entrySet()){
            Collections.sort(entry.getValue());
        }

        return adjList;

    }
}
