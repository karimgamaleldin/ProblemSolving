class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() + 1;
        int m = text2.length() + 1;
        int[][] dp = new int[n][m];
        for(int i = n - 2; i >= 0; i--){
            for(int j = m - 2; j >= 0 ; j--){
                char a = text1.charAt(i);
                char b = text2.charAt(j);
                if(a == b) dp[i][j] = 1 + dp[i + 1][j + 1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}