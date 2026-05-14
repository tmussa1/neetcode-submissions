class MyCalendar {

    class Time {
        int startTime;
        int endTime;

        Time(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    private TreeSet<Time> set;

    public MyCalendar() {
        this.set = new TreeSet<Time>((a, b) -> {
            if(a.startTime == b.startTime){
                return a.endTime - b.endTime;
            }
            return a.startTime - b.startTime;
        });
    }
    
    public boolean book(int startTime, int endTime) {
        Time time = new Time(startTime, endTime);
        Time prev = set.floor(time);
        Time next = set.ceiling(time);

        if(prev != null && startTime < prev.endTime){
            return false;
        }

        if(next != null && endTime > next.startTime){
            return false;
        }
        
        set.add(time);

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */