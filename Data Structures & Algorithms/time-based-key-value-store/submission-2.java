class TimeMap {


    Map<String, PriorityQueue<Map.Entry<String, Integer>>> timestampMap;

    public TimeMap() {
        this.timestampMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        PriorityQueue<Map.Entry<String, Integer>> queue = timestampMap.getOrDefault(key, new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()));
        queue.add(Map.entry(value, timestamp));
        timestampMap.put(key, queue);
    }
    
    public String get(String key, int timestamp) {
        PriorityQueue<Map.Entry<String, Integer>> queue = timestampMap.getOrDefault(key, new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()));

        PriorityQueue<Map.Entry<String, Integer>> tempQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        String value = "";

        while(!queue.isEmpty() && queue.peek().getValue() > timestamp){
            Map.Entry<String, Integer> entry = queue.poll();
            tempQueue.add(entry);
        }

        if(!queue.isEmpty() && queue.peek().getValue() <= timestamp){
            Map.Entry<String, Integer> entry = queue.poll();
            value = entry.getKey();
            tempQueue.add(entry);
        }

        queue.addAll(tempQueue);

        return value;
    }
}
