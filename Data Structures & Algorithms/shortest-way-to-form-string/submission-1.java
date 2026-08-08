class Solution {
    public int shortestWay(String source, String target) {

        Map<Character, Integer> countMap = new HashMap<>();

        for(int index = 0; index < source.length(); index++){
            char c = source.charAt(index);
            countMap.put(c, index);
        }
        
        int tIndex = 0, sIndex = 0, result = 0;

        while(tIndex < target.length()){
            char c = target.charAt(tIndex);

            if(!countMap.containsKey(c)){
                return -1;
            }

            if(c == source.charAt(sIndex)){
                sIndex++;
                tIndex++;
            } else {
                sIndex++;
            }

            if(sIndex == source.length()){
                sIndex = 0;
                result++;
            }
        }

        if(sIndex > 0){
            result++;
        }

        return result;
    }
}
