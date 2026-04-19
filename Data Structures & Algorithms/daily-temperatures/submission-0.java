class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> indexStack = new Stack<>();

        int [] result = new int[temperatures.length];

        int index = 0;

        while(index < temperatures.length){

            int temperature = temperatures[index];

            while(!indexStack.isEmpty() && temperature > temperatures[indexStack.peek()]){

                int top = indexStack.pop();

                result[top] = (index - top);
            }

            indexStack.push(index);

            index++;
        }


         return result;
    }
}
