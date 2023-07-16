class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans += getPalindromes(s , i , i) + getPalindromes(s , i , i + 1);
        }
        return ans;
        
    }
    public int getPalindromes(String s , int i , int j){
        int total = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--; j++; total++;
        }
        return total;
    }
        // DP
    //     int n = s.length();
    //     boolean[][] dp = new boolean[n][n];
    //     int total = n;
    //     for(int i = 0 ; i < n ; i++){
    //         dp[i][i] = true;
    //         if(i != n - 1 && s.charAt(i) == s.charAt(i + 1)) {
    //             dp[i][i+1] = true;
    //             total++;
    //         }
    //     }
    //     for(int diff = 2 ; diff < n ; diff++){
    //         for(int i = 0 ; i < n - diff ; i++){
    //             int j = i + diff;
    //             if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
    //                 dp[i][j] = true;
    //                 total++;
    //             }
    //         }
    //     }
    //     return total;
    // }
}