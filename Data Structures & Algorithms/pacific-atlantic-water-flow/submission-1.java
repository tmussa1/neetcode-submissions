class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        for(int row = 0; row < heights.length; row++){
            for(int col = 0; col < heights[0].length; col++){
                bfs(heights, row, col, result);
            }
        }

        return result;   
    }

    private void bfs(int [] [] heights, int row, int col, 
                    List<List<Integer>> result){

        Queue<int []> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int [] {row, col});
        visited.add(row + "," + col);
        int value = heights[row][col];

        int [] [] nextGrid = new int [] [] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean isPacific = false, isAtlantic = false;


        while(!queue.isEmpty()){

            int [] curr = queue.poll();
            
            for(int [] nextEntry: nextGrid){
                int nextRow = curr[0] + nextEntry[0];
                int nextCol = curr[1] + nextEntry[1];

                String key = nextRow + "," + nextCol;

                if(!visited.contains(key) && canProceed(heights, nextRow, nextCol, 
                            heights[curr[0]][curr[1]])){
                    queue.add(new int []{nextRow, nextCol});
                    visited.add(key);
                }
            }

            if(!isPacific){
                isPacific = isPacific(curr[0], curr[1]);
            }
    
            if(!isAtlantic){
                isAtlantic = isAtlantic(heights, curr[0], curr[1]);
            }
      
        }

        if(isPacific && isAtlantic){
            result.add(List.of(row, col));
        }
    }

    private boolean canProceed(int [] [] heights, int row, int col, int value){
        return row >= 0 && row < heights.length 
            && col >= 0 && col < heights[0].length 
            && value >= heights[row][col];
    }

    private boolean isPacific(int row, int col){
        return row == 0 || col == 0;
    }

    private boolean isAtlantic(int [] [] heights, int row, int col){
        return row == heights.length - 1 || col == heights[0].length - 1;
    }
}
