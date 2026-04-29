class Solution {
    public String simplifyPath(String path) {
        
        String [] pathSplit = path.split("/");

        Stack<String> stack = new Stack<>();

        int index = 0;

        while(index < pathSplit.length){

            if(pathSplit[index].equals(".")){
            } else if(pathSplit[index].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else if(!pathSplit[index].isEmpty()){
                stack.push(pathSplit[index]);
            }

            index++;
        }

        Collections.reverse(stack);

        StringBuilder builder = new StringBuilder();

        while(!stack.isEmpty()){
            builder.append("/");
            builder.append(stack.pop());
        }

        return builder.toString().length() == 0 ? "/" : builder.toString();
    }
}