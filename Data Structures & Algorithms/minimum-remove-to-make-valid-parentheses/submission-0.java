class Solution {

    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> indexStack = new Stack<>();

        StringBuilder builder = new StringBuilder();

        int bIndex = 0, sIndex = 0;

        while(sIndex < s.length()){
            char c = s.charAt(sIndex);

            if(c == ')'){
                if(!indexStack.isEmpty()){
                    builder.append(c);
                    indexStack.pop();
                    bIndex++;
                }
            } else if(c == '('){
                indexStack.push(bIndex);
                builder.append(c);
                bIndex++;
            } else {
                builder.append(c);
                bIndex++;
            }
            sIndex++;
        }

        while(!indexStack.isEmpty()){
            builder.deleteCharAt(indexStack.pop());
        }

        return builder.toString();
    }


}