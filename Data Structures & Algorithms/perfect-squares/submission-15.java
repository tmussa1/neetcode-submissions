class Solution {
    public int numSquares(int n) {

        int [] cache = new int[n + 1]; 

        Arrays.fill(cache, -1);

        return backtrack(n, cache);
    }

    private int backtrack(int n, int [] cache){

        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        if (n == 0) {
            return 0;
        }

        if(cache[n] != -1){
            return cache[n];
        }

        int result = Integer.MAX_VALUE;

        int maxSquare = (int) Math.sqrt(n);

        for (int i = maxSquare; i >= 1; i--) {
            int square = i * i;

            int res = backtrack(n - square, cache);

            if (res != Integer.MAX_VALUE) {
                result = Math.min(result, 1 + res);
            }
        }

        cache[n] = result;

        return result;
    }
}