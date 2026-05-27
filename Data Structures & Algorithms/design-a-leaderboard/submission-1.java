class Leaderboard {

    Map<Integer, Integer> playerMap;
    PriorityQueue<Integer> playerQueue;

    public Leaderboard() {
        this.playerMap = new HashMap<>();
        this.playerQueue = new PriorityQueue<>((a, b) -> playerMap.get(b) - playerMap.get(a));
    }
    
    public void addScore(int playerId, int score) {
        if(playerMap.containsKey(playerId)){
            playerQueue.remove(Integer.valueOf(playerId));
            playerMap.put(playerId, playerMap.get(playerId) + score);
            playerQueue.add(playerId);
        } else {
            playerMap.put(playerId, score);
            playerQueue.add(playerId);
        }
    }
    
    public int top(int K) {
        int sum = 0;
        List<Integer> tempList = new ArrayList<>();

        while(!playerQueue.isEmpty() && tempList.size() < K){
            int player = playerQueue.poll();
            tempList.add(player);
            sum += playerMap.get(player);
        }

        playerQueue.addAll(tempList);

        return sum;
    }
    
    public void reset(int playerId) {
        playerQueue.remove(Integer.valueOf(playerId));
        playerMap.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
