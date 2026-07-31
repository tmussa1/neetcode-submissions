class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        Integer [] [] cache = new Integer[text1.length()][text2.length()];

        return lcs(text1, text2, 0, 0, cache);
    }

    private int lcs(String text1, String text2, int t1, int t2, Integer [] [] cache){

        if(t1 == text1.length() || t2 == text2.length()){
            return 0;
        }

        if(cache[t1][t2] != null){
            return cache[t1][t2];
        }
        
        if(text1.charAt(t1) == text2.charAt(t2)){
            cache[t1][t2] = 1 + lcs(text1, text2, t1 + 1, t2 + 1, cache);
            return cache[t1][t2];
        }

        int result = 0;

        result += Math.max(lcs(text1, text2, t1 + 1, t2, cache), lcs(text1, text2, t1, t2 + 1, cache));

        cache[t1][t2] = result;

        return cache[t1][t2];
    }
}
