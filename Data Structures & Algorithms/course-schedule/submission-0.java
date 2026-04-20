class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = buildAdjList(prerequisites);

        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();

        for(int course = 0; course < numCourses; course++){
            if(hasCycle(adjList, visited, path, course)){
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> adjList, Set<Integer> visited,
        Set<Integer> path, int course){

        if(path.contains(course)){
            return true;
        }

        if(visited.contains(course)){
            return false;
        }


        visited.add(course);
        path.add(course);

        for(int neighbor: adjList.getOrDefault(course, new ArrayList<>())){
            if(hasCycle(adjList, visited, path, neighbor)){
                return true;
            }
        }

        path.remove(course);

        return false;
    }

    private Map<Integer, List<Integer>> buildAdjList(int[][] prerequisites){

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int [] prereqs: prerequisites){

            int prereq = prereqs[1], course = prereqs[0];

            List<Integer> prereqList = adjList.getOrDefault(course, new ArrayList<>());
            prereqList.add(prereq);

            adjList.put(course, prereqList);
        }

        return adjList;
    }
}
