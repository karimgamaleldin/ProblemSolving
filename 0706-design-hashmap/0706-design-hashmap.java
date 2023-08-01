class MyHashMap {
    List<Pair<Integer,Integer>>[] x;
    
    public MyHashMap() {
        this.x = new LinkedList[10000];
    }
    
    public void put(int key, int value) {
        this.remove(key);
        int hash = key % 10000;
        Pair<Integer , Integer> p = new Pair<>(key,value);
        if(x[hash] == null) x[hash] = new LinkedList<>();
        x[hash].add(p);
    }
    
    public int get(int key) {
        int hash = key % 10000;
        if(x[hash] == null) return -1;
        for(int i = 0 ; i < x[hash].size() ;i++){
            Pair<Integer,Integer> r = x[hash].get(i);
            if(r.getKey() == key){
                return r.getValue();
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = key % 10000;
        if(x[hash] == null) return;
        for(int i = 0 ; i < x[hash].size() ;i++){
            Pair<Integer,Integer> r = x[hash].get(i);
            if(r.getKey() == key){
                x[hash].remove(i);
                return;
            }
        }        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */