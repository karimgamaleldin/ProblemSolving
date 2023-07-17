class MyHashSet {
    LinkedList<Integer>[] arr;
    public MyHashSet() {
        arr = new LinkedList[10000];
    }
    
    public void add(int key) {
        int index = key % 10000;
        if(arr[index] == null){
            arr[index] = new LinkedList<>();
        }
        if(!arr[index].contains(new Integer(key))) arr[index].add(key);
    }
    
    public void remove(int key) {
        int index = key % 10000;
        if(arr[index] == null) return;
        arr[index].remove(new Integer(key));
    }
    
    public boolean contains(int key) {
        int index = key % 10000;
        if(arr[index] == null) return false;
        return arr[index].contains(new Integer(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */