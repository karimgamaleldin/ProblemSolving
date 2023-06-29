class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0 ; int j = 0;
        while(i < pushed.length || j < popped.length){
            if(i < pushed.length){
                if(pushed[i] == popped[j]) {
                    j++;
                    i++;
                }
                else if(!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
                else stack.push(pushed[i++]);
    
            }
            else{
                if(stack.pop() == popped[j]) j++;
                else return false;
            }
        }
        return true;
    }
}