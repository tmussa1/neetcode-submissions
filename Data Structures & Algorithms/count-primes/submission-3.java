class Solution {
    public int countPrimes(int n) {
        
        boolean [] sieve = new boolean[n + 1];

        int count = 0;


        for(int num = 2; num < n; num++){
            if(sieve[num] == true){
                continue;
            }
            sieve[num] = true;
            count++;

            for(int i = num; i <= n; i = i + num){
                sieve[i] = true;
            }
        }

        return count;
    }
}