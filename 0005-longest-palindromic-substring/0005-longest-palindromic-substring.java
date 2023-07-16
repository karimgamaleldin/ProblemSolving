class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int ans[] = new int[]{0,0};
        for(int i = 0 ; i < n ; i++) dp[i][i] = true;
        for(int i = 0 ; i < n - 1 ; i++){ 
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i+1] = true;
                ans[0] = i; ans[1] = i + 1;
            }
        }
        for(int diff = 2 ; diff < n ; diff++){
            for(int i = 0 ; i < n - diff ; i++){
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return s.substring(ans[0] , ans[1] + 1);
    }
    //     int n = s.length();
    //     String[] dp = new String[n];
    //     int ans = 0;
    //     String r = "kfsgl";
    //     for(int i = 0 ; i < n ; i++){
    //         for(int j = i ; j < n ; j++){
    //             if(isPalindrome(s , i , j) && ans < j - i + 1){
    //                 ans = j - i + 1;
    //                 r = s.substring(i , j + 1);
    //             }
    //         }
    //     }
    //     return r;
    // }
    // public boolean isPalindrome(String s , int i , int j){
    //     while(i <= j){
    //         if(s.charAt(i) != s.charAt(j)) return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}