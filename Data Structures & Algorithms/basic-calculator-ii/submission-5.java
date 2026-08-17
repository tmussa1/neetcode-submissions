class Solution {
    public int calculate(String s) {
        
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        int index = 0;

        while(index < s.length()){
            char c = s.charAt(index);

            if(c == '+' || c == '-' || c == '*' || c == '/'){
                 if((c == '+' || c == '-') && !operators.isEmpty()) {
                    char prev = operators.peek();

                    if(prev == '+' || prev == '-') {
                        int num2 = operands.pop();
                        int num1 = operands.pop();

                        operators.pop();

                        if(prev == '+') {
                            operands.push(num1 + num2);
                        } else {
                            operands.push(num1 - num2);
                        }
                    }
                }

                operators.push(c);
                index++;
            } else if(Character.isDigit(c)){
                int start = index;

                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    index++;
                }

                int num2 = Integer.parseInt(s.substring(start, index));

                if(operators.size() > 0){

                    char operator = operators.peek();

                    int num1 = operands.peek();

                    switch(operator){
                        case '*': {
                            operators.pop();
                            operands.pop();
                            operands.push(num1 * num2);
                            break;
                        }
                        case '/': {
                            operators.pop();
                            operands.pop();
                            operands.push(num1 / num2);
                            break;
                        }
                        default: {
                            operands.push(num2);
                        }
                    }
                } else {
                    operands.push(num2);
                }
            } else {
                index++;
            }
        }

        while(!operators.isEmpty() && operands.size() > 1){
            char operator = operators.pop();
            int num1 = operands.pop(), num2 = operands.pop();

            switch(operator){
                case '+': {
                    operands.push(num1 + num2);
                    break;
                }
                case '-': {
                    operands.push(num2 - num1);
                    break;
                }
                case '/': {
                    operands.push(num2 / num1);
                    break;
                }
                case '*': {
                    operands.push(num2 * num1);
                    break;
                }
            }
        }

        return operands.pop();
    }
}