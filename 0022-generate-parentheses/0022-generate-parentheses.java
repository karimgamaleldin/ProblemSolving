class Solution {
    char[] par = new char[] {'(' , ')'};
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        backtrack(n , r , new StringBuilder() , 0 , 0);
        return r;
    }
    public void backtrack(int n , List<String> r , StringBuilder sb , int left , int right){
        String s = sb.toString();
        if(sb.length() == n * 2){
            r.add(s);
            return;
        }
        if(left < n){
            sb.append('(');
            backtrack(n , r , sb , left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(')');
            backtrack(n , r , sb , left , right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public boolean check(String s){
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(c == '(') stack.push('(');
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }
}