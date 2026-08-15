class Solution {


    class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    TrieNode root = new TrieNode();

    private int findPrefix(String word){

        char [] chars = word.toCharArray();

        TrieNode curr = root;

        for(int index = 0; index < chars.length; index++){
            if(!curr.children.containsKey(chars[index])){
                return index;
            }
            curr = curr.children.get(chars[index]);
        }

        return chars.length;
    }

    private void addWord(String word){

        char [] chars = word.toCharArray();

        TrieNode curr = root;

        for(int index = 0; index < chars.length; index++){
            if(!curr.children.containsKey(chars[index])){
                curr.children.put(chars[index], new TrieNode());
            }
            curr = curr.children.get(chars[index]);
        }
    }

    public String longestCommonPrefix(String[] strs) {
        
        String word = strs[0];

        addWord(word);

        int length = word.length();

        String result = word;

        for(String str: strs){

            int prefix = findPrefix(str);

            if(prefix < length){
                result = str.substring(0, prefix);
                length = prefix;
            }
        }

        return result;
    }
}