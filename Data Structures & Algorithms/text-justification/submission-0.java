class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();

        List<String> currList = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        int index = 0, length = 0;

        while(index < words.length){

            if(length + words[index].length() + currList.size() > maxWidth){

                int extraSpace = maxWidth - length;
                int lastIndex = (currList.size() - 1);
                int equalSpace = extraSpace / Math.max(1, lastIndex);
                int leftOver = extraSpace % Math.max(1, lastIndex);

                for(int i = 0; i < lastIndex; i++){
                    String word = currList.get(i);
                    builder.append(word);
                    builder.append(" ".repeat(equalSpace));
                    if(leftOver > 0){
                        builder.append(" ");
                        leftOver--;
                    }
                }

                builder.append(currList.get(currList.size() - 1));
                if(lastIndex == 0){
                    builder.append(" ".repeat(extraSpace));
                }

                result.add(builder.toString());
                length = 0;
                currList = new ArrayList<>();
                builder = new StringBuilder();
            }

            length += words[index].length();
            currList.add(words[index]);
            index++;
        }

        int extraSpace = maxWidth - length;
        builder.append(String.join(" ", currList));
        extraSpace -= (currList.size() - 1);
        builder.append(" ".repeat(extraSpace)); 
        result.add(builder.toString());

        return result;
    }
}