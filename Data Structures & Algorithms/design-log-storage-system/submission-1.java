class LogSystem {

    List<Integer> ids = new ArrayList<>();
    Map<Integer, String> timestamps = new HashMap<>();

    public LogSystem() {
        
    }
    
    public void put(int id, String timestamp) {
        timestamps.put(id, timestamp); 
        ids.add(id);
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

        for (int id : ids) {

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
