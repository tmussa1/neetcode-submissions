class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        int index = 0;

        while(index < asteroids.length){

            int curr = asteroids[index];

            if(curr < 0){
                 if(!stack.isEmpty() && stack.peek() > 0) {
                    int toPush = curr;
                    while(!stack.isEmpty() && stack.peek() > 0){
                        int currStack = stack.pop();
                        int diff = currStack + curr;
                        if(diff > 0){
                            toPush = currStack;
                            break;
                        } else if(diff < 0){
                            toPush = curr;
                        } else {
                            toPush = Integer.MAX_VALUE;
                            break;
                        }
                    }

                    if(toPush != Integer.MAX_VALUE){
                        stack.push(toPush);
                    }
                 } else {
                    stack.push(curr);
                }
            } else {
                stack.push(curr);
            }

            index++;
        }

        int [] result = new int[stack.size()];
        index = stack.size() - 1;

        while(!stack.isEmpty()){
            result[index--] = stack.pop();
        }

        return result;
    }
}