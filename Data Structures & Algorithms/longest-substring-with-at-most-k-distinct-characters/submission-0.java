class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        Map<Character, Integer> countMap = new HashMap<>();

        int left = 0, right = 0, window = 0;

        while(right < s.length()){

            char currChar = s.charAt(right);
            countMap.put(currChar, countMap.getOrDefault(currChar, 0) + 1);

            while(countMap.size() > k){
                char leftChar = s.charAt(left);

                countMap.put(leftChar, countMap.getOrDefault(leftChar, 0) - 1);

                if(countMap.get(leftChar) == 0){
                    countMap.remove(leftChar);
                }

                left++;
            }

            window = Math.max(window, right - left + 1);
            
            right++;
        }

        return window;
    }
}
