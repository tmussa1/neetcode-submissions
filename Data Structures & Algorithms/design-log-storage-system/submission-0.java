class LogSystem {

    class TrieNode {
        String key;
        Set<Integer> logIds = new HashSet<>();
        Map<String, TrieNode> children = new HashMap<>();
    }

    TrieNode root = new TrieNode();
    Map<Integer, String> timestamps = new HashMap<>();

    private void addLogs(int id, String timestamp){

        String [] timestampSplit = timestamp.split(":");

        TrieNode curr = root;
        curr.logIds.add(id);

        for(int i = 0; i < timestampSplit.length; i++){
            String time = timestampSplit[i];

            if(!curr.children.containsKey(time)){
                curr.children.put(time, new TrieNode());
            }

            curr = curr.children.get(time);
            curr.logIds.add(id);
        }
    }

    private Set<Integer> findLogs(String timestamp){

        String [] timestampSplit = timestamp.split(":");

        TrieNode curr = root;

        for(int i = 0; i < timestampSplit.length; i++){

            String time = timestampSplit[i];

            if(!curr.children.containsKey(time)){
                return new HashSet<>();
            }

            curr = curr.children.get(time);
        }

        return curr.logIds;
    }

    public LogSystem() {
        
    }
    
    public void put(int id, String timestamp) {
        timestamps.put(id, timestamp); 
        addLogs(id, timestamp);
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        
        List<Integer> result = new ArrayList<>();

        int length;

        if (granularity.equals("Year")) {
            length = 4;
        } else if (granularity.equals("Month")) {
            length = 7;
        } else if (granularity.equals("Day")) {
            length = 10;
        } else if (granularity.equals("Hour")) {
            length = 13;
        } else if (granularity.equals("Minute")) {
            length = 16;
        } else {
            length = 19;
        }

        String startPrefix = start.substring(0, length);
        String endPrefix = end.substring(0, length);

        for (int id : root.logIds) {

            String timestamp = timestamps.get(id);
            String currPrefix = timestamp.substring(0, length);

            if (currPrefix.compareTo(startPrefix) >= 0 &&
                currPrefix.compareTo(endPrefix) <= 0) {

                result.add(id);
            }
        }

        return result;
    }

}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(startTimes, end,granularity);
 */
