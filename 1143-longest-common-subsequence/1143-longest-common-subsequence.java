class Solution {
    // recurrence relation Subsequence xy = subsequence x + subsequence y
    // base case subsequence 'a' = true
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         int[][] dp = new int[n + 1][m + 1];
//         for(int i = n - 1 ; i >= 0 ; i--){
//             char x = text1.charAt(i);
//             for(int j = m - 1 ; j >= 0 ; j--){
//                 char y = text2.charAt(j);
//                 if(x == y){
//                     dp[i][j] = 1 + dp[i + 1][j + 1]; 
//                 }else{
//                     dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]);
//                 }

//             }
//         }
//         return dp[0][0];
//     }
    int[][] memo;
    int n;
    int m;
    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        memo = new int[n][m];
        for(int i = 0 ; i < n ; i++) Arrays.fill(memo[i] , -1);
        return dp(0 , 0 , text1 , text2);
    }
    public int dp(int i , int j , String t1 , String t2){
        if(i == n || j == m) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        char c = t1.charAt(i);
        char d = t2.charAt(j);
        int x = 0;
        if(c == d){
            x = 1 + dp(i + 1 , j + 1 , t1 , t2);
        }else{
            x = Math.max(dp(i + 1 , j , t1 , t2) , dp(i , j + 1 , t1 , t2));
        }
        memo[i][j] = x;
        return x;
    }
    
}