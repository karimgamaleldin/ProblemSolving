class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ){
                stack.push(s.charAt(i));
            }
            else if(stack.empty()){
                return false;
            }
            else{
                char c = stack.pop();
                if(!closingTag(c,s.charAt(i))) return false;
            }
        }
        return stack.empty();
    }
    public boolean closingTag(char x , char y){
        return (x == '(' && y == ')') || (x == '{' && y == '}') || (x == '[' && y == ']');
    }
}