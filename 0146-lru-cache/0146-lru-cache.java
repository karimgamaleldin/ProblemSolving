class LRUCache {
    
    static class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    int cap;
    HashMap<Integer, Node> map;
    Node lr;
    Node mr;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.lr = new Node(0, 0);
        this.mr = new Node(0, 0);
        lr.next = mr;
        mr.prev = lr;
    }
    
    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        
    }
    
    public void insert(Node n){
        n.next = mr;
        n.prev = mr.prev;
        mr.prev.next = n;
        mr.prev = n;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        remove(map.get(key)); // remove the node
        insert(map.get(key)); // insert to the right most position
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            remove(map.get(key));
        }
        map.put(key, new Node(key, value));
        insert(map.get(key));
        if(map.size() > cap){
            Node lru = this.lr.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */