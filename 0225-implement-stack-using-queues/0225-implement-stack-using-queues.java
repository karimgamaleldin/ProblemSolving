class MyStack {
    Deque <Integer> q;
    public MyStack() {
        this.q = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        q.addLast(x);
    }
    
    public int pop() {
        for(int i = 0 ; i < q.size()-1 ; i++){
            q.addLast(q.pollFirst());
        }
        return q.pollFirst();
    }
    
    public int top() {
        for(int i = 0 ; i < q.size()-1 ; i++){
            q.addLast(q.pollFirst());
        }
        int x = q.pollFirst();
        q.addLast(x);
        return x;
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */