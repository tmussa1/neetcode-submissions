class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str: strs){

            char [] cArr = str.toCharArray();

            Arrays.sort(cArr);

            String word = new String(cArr);

            List<String> currList = anagramMap.getOrDefault(word, new ArrayList<>());
            currList.add(str);

            anagramMap.put(word, currList);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
