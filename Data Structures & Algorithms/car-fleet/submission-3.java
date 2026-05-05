class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        
        Stack<Integer> indexStack = new Stack<>();

        int length = position.length;

        double [][] aggregate = new double [length][2];

        for(int index = 0; index < length; index++){
            aggregate[index][0] = position[index];
            aggregate[index][1] = (target - position[index]) * 1.0 / speed[index];
        }

        Arrays.sort(aggregate, (a, b) -> {
            if(Double.compare(a[0], b[0]) == 0){
                return Double.compare(a[1], b[1]);
            }
            return Double.compare(a[0], b[0]);
        });

        int index = 0, fleets = 0;

        while(index < length){

            double currSec = aggregate[index][1];

            while(!indexStack.isEmpty() && currSec >= aggregate[indexStack.peek()][1]){
                indexStack.pop();
                fleets += 1;
            }
            indexStack.push(index);
            index++;
        }

        return length - fleets;
    }
}
