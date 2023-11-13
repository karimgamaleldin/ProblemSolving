class Solution {
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n][5];
        int mod = (int) Math.pow(10, 9) + 7;
        Arrays.fill(dp[0], 1);
        for(int i = 1; i < n; i++){
            int j = i - 1;
            dp[i][0] = dp[j][1] % mod;
            dp[i][1] = (dp[j][0] + dp[j][2]) % mod;
            dp[i][2] = ((dp[j][0] + dp[j][1]) % mod + (dp[j][3] + dp[j][4]) % mod) % mod;
            dp[i][3] = (dp[j][2] + dp[j][4]) % mod;
            dp[i][4] = (dp[j][0]) % mod;
        }
        int total = 0;
        for(int x : dp[n - 1]) total  = (total + x) % mod;
        return total;
    }
    
    public int returnIndex(char c){
        if(c == 'a') return 0;
        if(c == 'e') return 1;
        if(c == 'i') return 2;
        if(c == 'o') return 3;
        return 4;
    }
}