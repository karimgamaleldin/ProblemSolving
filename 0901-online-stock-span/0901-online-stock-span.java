class StockSpanner {
    
    Stack <Pair<Integer , Integer>> s ;
    public StockSpanner() {
        this.s = new Stack<>();
    }
    
    public int next(int price) {
        int r = 1;
        while(!s.isEmpty() && s.peek().getKey() <= price ){
            r += s.pop().getValue();
        }
        s.push(new Pair<Integer , Integer>(price , r));
        return r;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */