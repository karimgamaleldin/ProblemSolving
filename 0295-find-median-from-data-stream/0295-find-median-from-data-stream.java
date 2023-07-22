class MedianFinder {
    PriorityQueue<Integer> dec; // smaller numbers
    PriorityQueue<Integer> inc; // bigger numbers
    int size;
    public MedianFinder() {
        this.dec = new PriorityQueue<>(Comparator.reverseOrder());
        this.inc = new PriorityQueue<>();
        this.size = 0;
    }
    
    public void addNum(int num) {
        inc.add(num);
        dec.add(inc.remove());
        if(dec.size() > inc.size()) inc.add(dec.remove());
    }
    
    public double findMedian() {
        if(inc.size() > dec.size()) return inc.peek();
        return (inc.peek() + dec.peek()) / 2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */