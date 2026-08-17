class Solution {

     private int evaluate(char operator, int x, int y) {
        if (operator == '+') {
            return x;
        } else if (operator == '-') {
            return -x;
        } else if (operator == '*') {
            return x * y;
        }

        return x / y;
    }

    public int calculate(String s) {
        
        Stack<Integer> operands = new Stack<>();

        int index = 0;

        int current = 0;

        char operator = '+';

        while(index < s.length()){

            char c = s.charAt(index);

            if(Character.isDigit(c)){
                current = current * 10 + (c - '0');
            }
            
            if((!Character.isDigit(c) && c != ' ') || index == s.length() - 1){
                if(operator == '+' || operator == '-') {
                    operands.push(evaluate(operator, current, 0));
                } else if(operator == '*' || operator == '/'){
                    operands.push(evaluate(operator, operands.pop(), current));
                }
                operator = c;
                current = 0;
            } 
            
            index++;
        }

        int result = 0;

        for(int num: operands){
            result += num;
        }

        return result;
    }
}