class Solution {
    public boolean isMatch(String s, String p) {
        return doesMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean doesMatch(char [] sArr, char [] pArr, int sIndex, int pIndex){

        if(sIndex == sArr.length){
            while(pIndex + 1 < pArr.length && pArr[pIndex + 1] == '*'){
                pIndex += 2;
            }
            return pIndex == pArr.length;
        }

        boolean match = pIndex < pArr.length && (sArr[sIndex] == pArr[pIndex] || pArr[pIndex] == '.');

        if(pIndex + 1 < pArr.length && pArr[pIndex + 1] == '*'){
            if(doesMatch(sArr, pArr, sIndex, pIndex + 2)){
                return true;
            }

            if(match && doesMatch(sArr, pArr, sIndex + 1, pIndex)){
                return true;
            }
        }


        return match && doesMatch(sArr, pArr, sIndex + 1, pIndex + 1);
     }
}
