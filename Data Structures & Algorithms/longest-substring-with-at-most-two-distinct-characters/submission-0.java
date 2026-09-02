class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        Map<Character, Integer> countMap = new HashMap<>();

        int left = 0, right = 0, result = 0;

        char [] chars = s.toCharArray();

        while(right < s.length()){

            char c = chars[right];
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);

            while(countMap.size() > 2){

                char cL = chars[left];

                countMap.put(cL, countMap.getOrDefault(cL, 0) - 1);

                if(countMap.get(cL) == 0){
                    countMap.remove(cL);
                }

                left++;
            }

            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;
    }
}