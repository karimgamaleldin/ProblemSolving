class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            char x = s.charAt(i);
            if(x == '(' || x == '[' || x == '{') stack.push(x);
            else{
                if(stack.isEmpty()) return false;
                char y = stack.peek();
                if(y == '(' && x == ')' || y == '[' && x == ']' || y == '{' && x == '}') stack.pop();
                else return false;
            }
        }
        return stack.size() == 0;
    }
}