class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(memo, s, 0);
    }
    
    public int dp(int[] memo, String s, int i){
        if(i == s.length()) return 1;
        if(i > s.length()) return 0;
        if(s.charAt(i) == '0') return 0;
        if(memo[i] != -1) return memo[i];
        int x = 0;
        char c = s.charAt(i);
        x += dp(memo, s, i+1);
        if(c == '1' || (i < s.length() - 1 && c == '2' && s.charAt(i + 1) < '7')) x += dp(memo, s, i + 2);
        memo[i] = x;
        return x;
    }
}