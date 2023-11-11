class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(checkOpenBracket(c)) stack.push(c);
            else{
                if(stack.isEmpty() || !checkSimilarBrackets(stack.pop(), c)) return false;
            }
            
        }
        return stack.isEmpty();
    }
    
    private boolean checkOpenBracket(char c){
        return c == '(' || c == '[' || c == '{';
    }
    
    private boolean checkSimilarBrackets(char c, char d){
        if(d == ')') return c == '(';
        else if (d == ']') return c == '[';
        return c == '{';
    }
}