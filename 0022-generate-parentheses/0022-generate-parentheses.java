class Solution {
    char[] par = new char[] {'(' , ')'};
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        backtrack(2 * n , r , new StringBuilder());
        return r;
    }
    public void backtrack(int n , List<String> r , StringBuilder sb){
        if(sb.length() == n){
            String s = sb.toString();
            if(check(s)) r.add(s);
            return;
        }
        for(char p : par){
            sb.append(p);
            backtrack(n , r , sb);
            sb.delete(sb.length() - 1 , sb.length());
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
        return stack.size() == 0;
    }
}