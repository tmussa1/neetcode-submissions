class HitCounter {

    TreeMap<Integer, Integer> prefixMap;
    int hitCount;

    public HitCounter() {
        this.prefixMap = new TreeMap<Integer, Integer>();
        this.hitCount = 0;
        prefixMap.put(0, 0);
    }
    
    public void hit(int timestamp) {
        this.hitCount++;
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
