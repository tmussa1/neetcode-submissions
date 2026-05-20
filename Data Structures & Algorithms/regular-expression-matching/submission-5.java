class Solution {
    public boolean isMatch(String s, String p) {

        Boolean [] [] cache = new Boolean[s.length() + 1][p.length() + 1];

        return doesMatch(s.toCharArray(), p.toCharArray(), 0, 0, cache);
    }

    private boolean doesMatch(char [] sArr, char [] pArr, int sIndex, int pIndex, Boolean [] [] cache){

        if(sIndex == sArr.length){
            while(pIndex + 1 < pArr.length && pArr[pIndex + 1] == '*'){
                pIndex += 2;
            }
            return pIndex == pArr.length;
        }

        if(cache[sIndex][pIndex] != null){
            return cache[sIndex][pIndex];
        }

        boolean match = pIndex < pArr.length && (sArr[sIndex] == pArr[pIndex] || pArr[pIndex] == '.');

        if(pIndex + 1 < pArr.length && pArr[pIndex + 1] == '*'){
            if(doesMatch(sArr, pArr, sIndex, pIndex + 2, cache)){
                cache[sIndex][pIndex] = true;
                return true;
            }

            if(match && doesMatch(sArr, pArr, sIndex + 1, pIndex, cache)){
                cache[sIndex][pIndex] = true;
                return true;
            }
        }


        cache[sIndex][pIndex] = match && doesMatch(sArr, pArr, sIndex + 1, pIndex + 1, cache);

        return cache[sIndex][pIndex];
     }
}
