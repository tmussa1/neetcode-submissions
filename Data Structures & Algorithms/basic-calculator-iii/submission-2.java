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

    int index = 0;

    public int calculate(String s){

        if(index == s.length()){
            return 0;
        }

        Stack<Integer> operands = new Stack<>();

        int current = 0;
        char operator = '+';

        while (index < s.length()) {

            char c = s.charAt(index);

            if(Character.isDigit(c)){
                current = (current * 10) + (c - '0');
            } else if(c == '('){
                index++;
                current = calculate(s);
            }
            
            if ((!Character.isDigit(c) && c != ' ') || index == s.length() - 1){
                if(operator == '+' || operator == '-'){
                    operands.push(evaluate(operator, current, 0));
                } else if(operator == '*' || operator == '/'){
                    operands.push(evaluate(operator, operands.pop(), current));
                } 

                if(c == ')'){
                    break;
                }

                current = 0;
                operator = c;
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
