class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer, Integer> countMap = new HashMap<>();

        int left = 0, right = 0, window = 0;

        while(right < fruits.length){

            int fruit = fruits[right];
            countMap.put(fruit, countMap.getOrDefault(fruit, 0) + 1);

            while(countMap.size() > 2){

                int leftFruit = fruits[left];
                countMap.put(leftFruit, countMap.getOrDefault(leftFruit, 0) - 1);

                if(countMap.get(leftFruit) == 0){
                    countMap.remove(leftFruit);
                }

                left++;
            }

            window = Math.max(window, right - left + 1);


            right++;
        }

        return window;
    }
}