class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            char x = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != x) stack.push(x);
            else stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0 , stack.pop());
        }
        return sb.toString();
    }
}