class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);

        for(int stone: stones){
            queue.add(stone);
        }

        while(queue.size() > 1){

            int first = queue.poll(), second = queue.poll();

            int diff = Math.abs(first - second);

            if(diff > 0){
                queue.add(diff);
            }
        }

        return queue.size() == 1 ? queue.poll() : 0;
    }
}
