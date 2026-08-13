class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = Arrays.stream(matchsticks).sum();

        if(sum % 4 != 0){
            return false;
        }

        int target = sum / 4;

        Arrays.sort(matchsticks);

        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }

        if (matchsticks[0] > target) {
            return false;
        }

        Boolean [] visited = new Boolean[matchsticks.length];

        return howManyFits(matchsticks, 0, 0, target, 0, visited);
    }

    private boolean howManyFits(int[] matchsticks, int index, int current, int target, int sidesFormed, Boolean [] visited){

        if(index >= matchsticks.length){
            return sidesFormed == 3;
        }

        if(current > target){
            return false;
        }

        if(current == target){
            return howManyFits(matchsticks, 0, 0, target, sidesFormed + 1, visited);
        }

        if(visited[index] != null && (visited[index] == true || current + matchsticks[index] > target)){
            return howManyFits(matchsticks, index + 1, current, target, sidesFormed, visited);
        } 

        visited[index] = true; 

        if (howManyFits(matchsticks, index + 1, current + matchsticks[index], target, sidesFormed, visited)) {
            return true;
        }

        visited[index] = false;

        return howManyFits(matchsticks, index + 1, current, target, sidesFormed, visited);
    }
}