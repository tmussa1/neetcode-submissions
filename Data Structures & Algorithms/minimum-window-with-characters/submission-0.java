class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> tCountMap = new HashMap<>();
        Map<Character, Integer> sCountMap = new HashMap<>();

        for(int index = 0; index < t.length(); index++){
            char c = t.charAt(index);
            tCountMap.put(c, tCountMap.getOrDefault(c, 0) + 1);
        }
        
        int uniqueMatches = 0;

        int left = 0, right = 0, window = Integer.MAX_VALUE;

        int [] result = new int[2];

        while(right < s.length()){
            char c = s.charAt(right);

            if(tCountMap.containsKey(c)){
                sCountMap.put(c, sCountMap.getOrDefault(c, 0) + 1);
                if(sCountMap.get(c) == tCountMap.get(c)){
                    uniqueMatches++;
                }
            }

            while(uniqueMatches == tCountMap.size()){

                char leftChar = s.charAt(left);

                if(sCountMap.containsKey(leftChar)){

                    if(sCountMap.get(leftChar) == tCountMap.get(leftChar)){
                        uniqueMatches--;
                    }

                    sCountMap.put(leftChar, sCountMap.getOrDefault(leftChar, 0) - 1);

                    if(sCountMap.get(leftChar) == 0){
                        sCountMap.remove(leftChar);
                    }
                }

                if(right - left + 1 < window){
                    window = right - left + 1;
                    result[0] = left;
                    result[1] = right + 1;
                }

                left++;
            }


            right++;
        }

        return s.substring(result[0], result[1]);
    }
}
