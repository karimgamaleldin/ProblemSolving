class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '*' && !stack.isEmpty()) stack.pop();
            else stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0 , stack.pop());
        }
        return sb.toString();
    }
}