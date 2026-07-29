class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        Map<String, List<String>> sequenceMap = new HashMap<>();

        for(String word: strings){
            String key = createKey(word);
            sequenceMap.putIfAbsent(key, new ArrayList<String>());
            sequenceMap.get(key).add(word);
        }

        return new ArrayList<>(sequenceMap.values());
    }

    private String createKey(String word){
        char [] chars = word.toCharArray();
        char first = chars[0];
        StringBuilder builder = new StringBuilder();

        for(char c: chars){
            int diff = ((c - first) + 26) % 26;
            builder.append(diff + ",");
        }

        return builder.toString();
    }
}
