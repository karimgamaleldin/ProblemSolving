class SeatManager {
    PriorityQueue<Integer> seats;
    HashSet<Integer> reserved;
    public SeatManager(int n) {
        this.seats = new PriorityQueue<Integer>();
        for(int i = 1 ; i <= n ; i++) seats.add(i);
        reserved = new HashSet<>();
    }
    
    public int reserve(){
        int i = seats.remove();
        reserved.add(i);
        return i;
    }
    
    public void unreserve(int seatNumber) {
        reserved.remove(seatNumber);
        seats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */