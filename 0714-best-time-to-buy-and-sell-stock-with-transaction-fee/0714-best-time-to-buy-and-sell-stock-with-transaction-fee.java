class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for(int i = n - 1; i>=0 ; i--){
            dp[i][0] = Math.max(dp[i + 1][1] - prices[i] - fee, dp[i + 1][0]);
            dp[i][1] = Math.max(dp[i + 1][0] + prices[i], dp[i + 1][1]);
        }
        // printMatrix(dp);
        return dp[0][0];
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }
    }
}