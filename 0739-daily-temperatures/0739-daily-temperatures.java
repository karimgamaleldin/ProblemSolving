class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] r = new int[temperatures.length];
        Stack<Integer> indicies = new Stack<>();
        for(int i = 0 ; i < temperatures.length ; i++){
            int x = temperatures[i];
            while(!indicies.empty() && x > temperatures[indicies.peek()]) r[indicies.peek()] = i - indicies.pop();
            indicies.push(i);
        }
        return r;
    }
}