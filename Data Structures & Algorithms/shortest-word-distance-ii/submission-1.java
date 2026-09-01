class WordDistance {

    Map<String, List<Integer>> wordIndexMap;

    public WordDistance(String[] wordsDict) {
        this.wordIndexMap = new HashMap<>();

        for(int index = 0; index < wordsDict.length; index++){
            this.wordIndexMap.putIfAbsent(wordsDict[index], new ArrayList<>());
            this.wordIndexMap.get(wordsDict[index]).add(index);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> lst1 = this.wordIndexMap.get(word1);
        List<Integer> lst2 = this.wordIndexMap.get(word2);

        int min = Integer.MAX_VALUE;

        for(Integer index1 : lst1){
            for(Integer index2 : lst2){
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
