class Solution {
    public boolean wordBreak(String word, List<String> wordDict) {
        Boolean [] cache = new Boolean[word.length() + 1];
        return canSegment(word, new HashSet<>(wordDict), 0, cache);
    }

    private boolean canSegment(String word, Set<String> dictionary, 
                               int index, Boolean [] cache){

        if(index >= word.length()){
            return true;
        }

        if(cache[index] != null){
            return cache[index];
        }

        for(int i = index + 1; i <= word.length(); i++){

            boolean contained = dictionary.contains(word.substring(index, i));

            if(contained && canSegment(word, dictionary, i, cache)){
                cache[index] = true;
                return true;
            }
        }

        cache[index] = false;

        return cache[index];
    }
}
