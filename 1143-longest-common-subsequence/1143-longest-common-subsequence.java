class Solution {
    // recurrence relation Subsequence xy = subsequence x + subsequence y
    // base case subsequence 'a' = true
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = n - 1 ; i >= 0 ; i--){
            char x = text1.charAt(i);
            for(int j = m - 1 ; j >= 0 ; j--){
                char y = text2.charAt(j);
                if(x == y){
                    dp[i][j] = 1 + dp[i + 1][j + 1]; 
                }else{
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]);
                }

            }
        }
        return dp[0][0];
    }
}