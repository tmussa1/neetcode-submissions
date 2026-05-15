class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> characterStack = new Stack<>();

        int index = 0;

        char [] sArr = s.toCharArray();

        while(index < s.length()){
            char c = sArr[index];

            if(Character.isDigit(c)){

                int beginIndex = index;

                while(Character.isDigit(sArr[index])){
                    index++;
                }

                int num = Integer.parseInt(s.substring(beginIndex, index));
                numberStack.push(num);
            } else if(c == ']'){
                int num = numberStack.pop();

                StringBuilder builder = new StringBuilder();

                while(!characterStack.isEmpty() && !characterStack.peek().equals("[")){
                    builder.append(characterStack.pop());
                }
                characterStack.pop();
                characterStack.push(builder.toString().repeat(num));
                index++;
            } else {
                characterStack.push(c + "");
                index++;
            }

            System.out.println(characterStack);
            System.out.println(numberStack);
            System.out.println("Tofik");
        }

        StringBuilder builder = new StringBuilder();

        while(!characterStack.isEmpty()){
            builder.append(characterStack.pop());
        }

        return builder.reverse().toString();
    }
}