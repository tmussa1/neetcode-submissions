class Solution {
    public int uniquePaths(int m, int n) {
        Integer [][] cache = new Integer [m][n];

        return uniquePath(0, 0, m, n, cache);
    }

    private int uniquePath(int x, int y, int m, int n, Integer [][] cache){

        if(x == m - 1 && y == n - 1){
            return 1;
        }

        if(x >= m || y >= n){
            return 0;
        }

        if(cache[x][y] != null){
            return cache[x][y];
        }

        int result = 0;

        result += uniquePath(x + 1, y, m, n, cache);
        result += uniquePath(x, y + 1, m, n, cache);

        cache[x][y] = result;

        return cache[x][y];
    }
}
