class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int length = flowerbed.length;
        
        int [] flowers = new int[length + 2];

        for(int index = 1; index <= length; index++){
            flowers[index] = flowerbed[index - 1];
        }

        int index = 1;

        while(index < length + 1){
            if(flowers[index] == 0 && flowers[index - 1] == 0 && flowers[index + 1] == 0){
                flowers[index] = 1;
                n--;
            }

            index++; 
        }

        return n <= 0;
    }
}