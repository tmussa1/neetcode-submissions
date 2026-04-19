class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        int index = 0;

        while(index < tokens.length){
            String currWord = tokens[index];

            boolean isOperator = currWord.equals("+") 
            || currWord.equals("-")
            || currWord.equals("*")
            || currWord.equals("/");

            if(isOperator){
                int left = numStack.pop(), right = numStack.pop();
                
                if(currWord.equals("+")){
                    numStack.push(left + right);
                } else if(currWord.equals("*")) {
                    numStack.push(left * right);
                } else if(currWord.equals("/")) {
                    numStack.push(right / left);
                } else if(currWord.equals("-")) {
                    numStack.push(right - left);
                }

            } else {
                numStack.push(Integer.parseInt(currWord));
            }

            index++;
        }

        return numStack.pop();
    }
}
