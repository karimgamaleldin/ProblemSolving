class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < operations.length ; i++){
            if(operations[i].equals("+")){
                int x = stack.pop();
                int y = stack.peek();
                stack.push(x);
                stack.push(x+y);
            }
            else if(operations[i].equals("D")){
                stack.push(stack.peek() * 2);
            }
            else if(operations[i].equals("C")) {
                stack.pop();
            } 
            else{
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        int r = 0;
        while(!stack.empty()){
            r += stack.pop();
        }
        return r;
    }
}