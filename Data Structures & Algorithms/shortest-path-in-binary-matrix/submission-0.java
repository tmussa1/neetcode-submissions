class Solution {

    int [][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, 
     {1, -1}, {-1, 1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] != 0){
            return -1;
        }
        
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int [] {0, 0});

        int distance = 1;

        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int [] curr = queue.poll();
                String key = curr[0] + "," + curr[1];
                visited.add(key);

                if(curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1){
                    return distance;
                }

                for(int [] direction: directions){

                    int nextRow = curr[0] + direction[0];
                    int nextCol = curr[1] + direction[1];

                    if(isInBounds(grid, nextRow, nextCol, visited)){
                        queue.add(new int[] { nextRow, nextCol });
                    }
                }
            }

            distance++;
        }

        return -1;
    }

    private boolean isInBounds(int[][] grid, int row, int col, Set<String> visited){

        String key = row + "," + col;

        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
         && grid[row][col] == 0 && !visited.contains(key);
    }
}