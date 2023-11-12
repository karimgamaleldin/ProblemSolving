class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0 ; i < n + 1 ; i++) dp[i][0] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= amount ; j++){
                int x = j - coins[i - 1] < 0 ? 0 : dp[i][j - coins[i - 1]];
                dp[i][j] = x + dp[i - 1][j];
            }
        }
        // printMatrix(dp);
        return dp[n][amount];
    }
    void printMatrix(int[][] x){
        for(int i = 0 ; i < x.length; i++){
            for(int j = 0; j < x[0].length; j++){
                System.out.print(x[i][j] + ", ");
            }
            System.out.println();
        }
    }
}