class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(s , p , 0 , 0 , memo);
    }
    public boolean dp(String s , String p , int i , int j , Boolean[][] memo){
        if(i >= s.length() && j >= p.length()) return true;
        if(j >= p.length()) return false;
        if(memo[i][j] != null) return memo[i][j];
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
        if(p.charAt(j) == '*'){
            boolean temp = i < s.length() && dp(s,p,i+1,j,memo) || dp(s,p,i,j+1,memo);
            memo[i][j] = temp;
            return temp;
        }
        boolean temp = match && dp(s,p,i+1,j+1,memo);
        memo[i][j] = temp;
        return temp;
    }
}