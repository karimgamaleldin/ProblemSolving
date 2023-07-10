class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        int size = q.size();
        int c = 1;
        for(int i = 0 ; i < size ; i++){
            int x = q.poll();
            if(t - x <= 3000){
                c++;
                q.offer(x);
            }
        }
        q.offer(t);
        return c;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */