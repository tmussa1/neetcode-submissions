class PhoneDirectory {

    int [] directory;
    PriorityQueue<Integer> indexQueue;
    int index;

    public PhoneDirectory(int maxNumbers) {
        this.directory = new int[maxNumbers];
        this.indexQueue = new PriorityQueue<Integer>();
    }
    
    public int get() {

        if(index >= directory.length){

            if(indexQueue.isEmpty()){
                return -1;
            }

            int ind = indexQueue.poll();
            directory[ind] = -1;

            return ind;
        }

        directory[index] = -1;

        int returned = index;

        this.index++;

        return returned;
    }
    
    public boolean check(int number) {
        if(number >= directory.length){
            return false;
        }
        return directory[number] != -1;
    }
    
    public void release(int number) {
        directory[number] = 0;
        indexQueue.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
