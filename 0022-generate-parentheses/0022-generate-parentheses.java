class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n , sb , ans , 0 , 0);
        return ans;
    }
    public static void backtrack(int n , StringBuilder sb , List<String> ans , int left , int right){
        if(left == n && right == n){
            ans.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append('(');
            backtrack(n , sb , ans , left + 1 , right);
            sb.deleteCharAt(-1 + sb.length());
        }
        
        if(right < left){
            sb.append(')');
            backtrack(n , sb , ans , left , right + 1);
            sb.deleteCharAt(-1 + sb.length());
        }
    }
}