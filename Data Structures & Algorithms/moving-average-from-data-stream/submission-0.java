class MovingAverage {

    int size;
    int current;
    int sum;
    TreeMap<Integer, Integer> prefixMap;

    public MovingAverage(int size) {
        this.size = size;
        this.current = 0;
        this.sum = 0;
        this.prefixMap = new TreeMap<>();
        this.prefixMap.put(0, 0);
    }
    
    public double next(int val) {
        this.sum += val;
        this.current++;
        int prefixSum = 0;

        if(this.current > this.size){
            prefixSum = this.prefixMap.floorEntry(this.current - this.size).getValue();
        } 
        
        this.prefixMap.put(this.current, this.sum);

        double result = (this.sum - prefixSum) * 1.0 / Math.min(this.current, this.size);
        
        return result;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
