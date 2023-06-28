class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(!stack.isEmpty() && (sameUpperLower(stack.peek() , s.charAt(i) ) || sameUpperLower(s.charAt(i) , stack.peek()))){
                stack.pop();
            }else stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
    public boolean sameUpperLower(char lower , char upper){
        int x = 'a' - 'A';
        int upperI = x + upper;
        return (lower - upperI) == 0;
    }
}