class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
            indegreeMap.put(i, 0);
        }

        populateMap(adjList, indegreeMap, prerequisites);

        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry: indegreeMap.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }

        System.out.println(indegreeMap);

        int [] result = new int[numCourses];
        int index = 0, visitedCount = 0;

        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                visitedCount++;
                result[index++] = curr;
                visited.add(curr);

                for(int neighbor: adjList.get(curr)){
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);
                    if(indegreeMap.get(neighbor) == 0 && !visited.contains(neighbor)){
                        queue.add(neighbor);
                    }
                }
            }
        }

        if(visitedCount != numCourses){
            return new int[]{};
        }

        return result;
    }

    private void populateMap(Map<Integer, List<Integer>> adjList, 
        Map<Integer, Integer> indegreeMap, int[][] prerequisites){

        for(int [] prereq: prerequisites){
            indegreeMap.put(prereq[0], indegreeMap.get(prereq[0]) + 1);
            adjList.get(prereq[1]).add(prereq[0]);
        }
    }
}
