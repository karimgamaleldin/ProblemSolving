class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] r = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            int x = temperatures[i];
            while(!stack.isEmpty() && x > temperatures[stack.peek()] ){
                int y = stack.pop();
                r[y] = i - y; 
            }
            stack.push(i);
        }
        return r;
    }
}