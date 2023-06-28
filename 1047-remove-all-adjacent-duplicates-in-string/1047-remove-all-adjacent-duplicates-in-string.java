class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            if (stack.isEmpty()) stack.push(s.charAt(i));
            else if(stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            }else stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}