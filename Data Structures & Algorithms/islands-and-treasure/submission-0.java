class Solution {
    public void islandsAndTreasure(int[][] grid) {
        bfs(grid);
    }

    private void bfs(int[][] grid){

        Set<String> visited = new HashSet<>();
        Queue<int []> queue = new LinkedList<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0){
                   queue.add(new int[] {row, col});
                }
            }
        }

        int [] [] nextElements = new int [] [] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int distance = 0; 

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int [] curr = queue.poll();
                grid[curr[0]][curr[1]] = distance;

                for(int [] nextElement: nextElements){

                    int row = curr[0] + nextElement[0];
                    int col = curr[1] + nextElement[1];

                    String key = row + "," + col;

                    if(row < 0 || row == grid.length || col < 0 
                        || col == grid[0].length || grid[row][col] == -1 
                        || grid[row][col] == 0 
                        || visited.contains(key)){
                        continue;
                    }
                    visited.add(key);
                    queue.add(new int[] {row, col});
                }
            }
            distance++;
        } 
    }
}
