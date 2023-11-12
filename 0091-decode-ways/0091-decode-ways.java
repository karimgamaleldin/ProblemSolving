class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for(int i = n - 2; i >=0  ; i--){
            char c = s.charAt(i);
            if(c == '0') dp[i] = 0;
            else{
                dp[i] = dp[i + 1];
                if(Integer.parseInt(s.substring(i , i + 2)) < 27) dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}