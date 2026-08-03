class HitCounter {

    TreeMap<Integer, Integer> timestampMap;
    TreeMap<Integer, Integer> prefixMap;
    int hitCount;

    public HitCounter() {
        this.timestampMap = new TreeMap<Integer, Integer>();
        this.prefixMap = new TreeMap<Integer, Integer>();
        this.hitCount = 0;
        prefixMap.put(0, 0);
    }
    
    public void hit(int timestamp) {
        this.hitCount++;
        timestampMap.put(timestamp, timestampMap.getOrDefault(timestamp, 0) + 1);
        prefixMap.put(timestamp, hitCount);
    }
    
    public int getHits(int timestamp) {
        Map.Entry<Integer, Integer> entry = prefixMap.floorEntry(Math.max(0, timestamp - 300));
        Map.Entry<Integer, Integer> entry2 = prefixMap.floorEntry(timestamp);

        return entry2.getValue() - entry.getValue();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
