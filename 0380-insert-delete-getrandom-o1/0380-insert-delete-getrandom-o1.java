class RandomizedSet {
    LinkedList<Integer> arr;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        this.arr = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
    if (!map.containsKey(val)) return false;

    int indexToRemove = map.get(val);
    int lastElement = arr.get(arr.size() - 1);

    // Move the last element to the place of the element to be removed
    arr.set(indexToRemove, lastElement);
    map.put(lastElement, indexToRemove);

    // Remove the last element
    arr.remove(arr.size() - 1);
    map.remove(val);

    return true;
}

    
    public int getRandom() {
        int index = (int) (Math.random() * arr.size()) ;
        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */