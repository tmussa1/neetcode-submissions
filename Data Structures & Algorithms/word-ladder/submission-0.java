class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }

        Map<String, List<String>> adjList = buildAdjList(wordList);

        char [] beginWordArr = beginWord.toCharArray();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int result = 1;

        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int index = 0; index < size; index++){

                String word = queue.poll();

                if(word.equals(endWord)){
                    return result;
                }

                char [] wordArr = word.toCharArray();

                for(int index1 = 0; index1 < word.length(); index1++){
                    char temp = wordArr[index1];
                    wordArr[index1] = '*';
                    String word1 = new String(wordArr);

                    if(adjList.containsKey(word1) && !visited.contains(word1)){
                        List<String> list = adjList.get(word1);
                        visited.add(word1);
                        queue.addAll(list);
                    }

                    wordArr[index1] = temp;
                }
            }


            result++;
        }

        return 0;
    }

    Map<String, List<String>> buildAdjList(List<String> wordList){

        Map<String, List<String>> adjList = new HashMap<>();

        for(String word: wordList){
            char [] wordArr = word.toCharArray();
            for(int index = 0; index < word.length(); index++){
                char temp = wordArr[index];
                wordArr[index] = '*';
                String word1 = new String(wordArr);
                List<String> list = adjList.getOrDefault(word1, new ArrayList<>());
                list.add(word);
                adjList.put(word1, list);
                wordArr[index] = temp;
            }
        }

        return adjList;
    }
}
