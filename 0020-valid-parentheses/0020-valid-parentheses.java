class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                char x = stack.peek();
                if(x == '(' && c == ')'|| x == '[' && c == ']' || x == '{' && c == '}') stack.pop();
                else return false;
            }
        }
        return stack.size() == 0;
    }
}