class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);
        
        int left = 0, right = piles[piles.length - 1];

        while(left < right){

            int k = left + ((right - left) / 2);

            int hours = findHoursToEat(piles, k);

            if(hours <= h){
                right = k;
            } else if(hours > h){
                left = k + 1;
            } 
        }

        return right;
    }

    private int findHoursToEat(int[] piles, int k){

        int hours = 0;

        for(int pile: piles){
            hours += Math.ceil(pile / (k * 1.0));
        }

        return hours;
    }
}
