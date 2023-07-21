class FreqStack {
    Map<Integer , Stack<Integer>> freqToStack;
    Map<Integer , Integer> numberToFreq;
    int maxFreqStackNumber;
    public FreqStack() {
        this.freqToStack = new HashMap<>();
        this.numberToFreq = new HashMap<>();
        this.maxFreqStackNumber = 0;
    }
    
    public void push(int val) {
        int f = numberToFreq.getOrDefault(val , 0) + 1;
        numberToFreq.put(val , f);
        maxFreqStackNumber = Math.max(maxFreqStackNumber , f);
        if(!freqToStack.containsKey(f)) freqToStack.put(f , new Stack<Integer>());
        freqToStack.get(f).push(val);
    }
    
    public int pop() {
        Stack<Integer> s = freqToStack.get(maxFreqStackNumber);
        int r = s.pop();
        if(s.isEmpty()){
            maxFreqStackNumber--;
        }
        numberToFreq.put(r , numberToFreq.get(r) - 1);
        return r;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */