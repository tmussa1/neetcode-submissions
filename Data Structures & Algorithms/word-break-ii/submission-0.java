class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>();
        findWords(s, new HashSet<>(wordDict), 0, result, new LinkedList<String>());

        List<String> answer = new ArrayList<>();

        for(List<String> res: result){
            answer.add(String.join(" ", res));
        }

        return answer;
    }

    private void findWords(String s, Set<String> wordDict, int index, 
        List<List<String>> result, LinkedList<String> currList){

        if(index == s.length()){
            result.add(new ArrayList<>(currList));
            return;
        }


        for(int i = index; i <= s.length(); i++){
            String word = s.substring(index, i);

            if(wordDict.contains(word)){
                currList.add(word);
                findWords(s, wordDict, i, result, currList);
                currList.removeLast();
            }
        }
    }
}