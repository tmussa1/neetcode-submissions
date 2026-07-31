class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        Integer [][] cache = new Integer [m][n];
        return uniquePath(obstacleGrid, 0, 0, m, n, cache);
    }

    private int uniquePath(int[][] obstacleGrid, int x, int y, int m, int n, Integer [][] cache){

        if(x >= m || y >= n){
            return 0;
        }

        if(obstacleGrid[x][y] == 1){
            return 0;
        }

        if(x == m - 1 && y == n - 1){
            return 1;
        }

        if(cache[x][y] != null){
            return cache[x][y];
        }

        int result = 0;

        result += uniquePath(obstacleGrid, x + 1, y, m, n, cache);
        result += uniquePath(obstacleGrid, x, y + 1, m, n, cache);

        cache[x][y] = result;

        return cache[x][y];
    }
}