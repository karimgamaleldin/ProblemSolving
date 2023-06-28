class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if (stack.isEmpty()) stack.push(s.charAt(i));
            else if(stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            }else stack.pop();
        }
        String x = "";
        while(!stack.isEmpty()){
            x = stack.pop() + x;
        }
        return x;
    }
}