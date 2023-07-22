class MedianFinder {
    PriorityQueue<Integer> minHeap; // smaller numbers
    PriorityQueue<Integer> maxHeap; // bigger numbers
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.maxHeap = new PriorityQueue<>();
    }
    
public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */