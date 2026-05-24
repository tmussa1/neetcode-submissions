class RandomizedSet {

    private Map<Integer, Integer> randMap;
    int size = 0;

    public RandomizedSet() {
        this.randMap = new HashMap<>();
    }
    
    public boolean insert(int val) {

        if(randMap.containsKey(val)){
            return false;
        }
        randMap.put(val, size++);

        return true;
    }
    
    public boolean remove(int val) {

        if(!randMap.containsKey(val)){
            return false;
        }

        randMap.remove(val);
        size--;

        return true;
    }
    
    public int getRandom() {
        int rand = (int) (Math.random() * size);
        return new ArrayList<Integer>(randMap.keySet()).get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */