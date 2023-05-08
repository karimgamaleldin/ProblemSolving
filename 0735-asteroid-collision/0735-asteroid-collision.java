class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < asteroids.length ; i++){
            int x = asteroids[i];
            if(stack.empty()) stack.push(x);
            else if(stack.peek() > 0 && x < 0){
                int y = stack.peek();
                if(Math.abs(y) == Math.abs(x)) stack.pop();
                else if(Math.abs(y) < Math.abs(x)){
                    stack.pop();
                    i--;
                }
            }
            else stack.push(x);
        }
        int[] arr = new int[stack.size()];
        for(int i = stack.size() - 1 ; i >= 0 ; i--) arr[i] = stack.pop();
        return arr;
    }
}