class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int window = 0;

        Map<Character, Integer> indexMap = new HashMap<>();

        int left = 0, right = 0;

        while(right < s.length()){

            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            while(indexMap.containsKey(rightChar)){
                indexMap.remove(s.charAt(left));
                left++;
            }

            indexMap.put(rightChar, right);

            window = Math.max(window, right - left + 1);

            right++;
        }

        return window;
    }
}
