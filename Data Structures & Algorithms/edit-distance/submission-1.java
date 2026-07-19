class Solution {
    public int minDistance(String word1, String word2) {
        Integer [][] memo = new Integer[word1.length()][word2.length()];
        return findMinDistance(word1.toCharArray(), word2.toCharArray(), 0, 0, memo);
    }

    private int findMinDistance(char [] word1, char [] word2, int index1, int index2,
       Integer [][] memo){

        if(index1 == word1.length && index2 == word2.length){
            return 0;
        }

        if(index1 == word1.length){
            return word2.length - index2;
        }

        if(index2 == word2.length){
            return word1.length - index1;
        }

        if(memo[index1][index2] != null){
            return memo[index1][index2];
        }

        if(word1[index1] == word2[index2]){
            memo[index1][index2] = findMinDistance(word1, word2, index1 + 1, index2 + 1, memo);
            return memo[index1][index2];
        } else {
            memo[index1][index2] = 1 + Math.min(Math.min(findMinDistance(word1, word2, index1 + 1, index2, memo), 
                            findMinDistance(word1, word2, index1, index2 + 1, memo)), 
                            findMinDistance(word1, word2, index1 + 1, index2 + 1, memo));
            return memo[index1][index2];
        }
    }
}
