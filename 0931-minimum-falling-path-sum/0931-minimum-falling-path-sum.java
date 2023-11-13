class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++) dp[n - 1][i] = matrix[n - 1][i];
        for(int i = n - 2; i >= 0 ; i--){
            for(int j = 0; j < n; j++){
                int min = dp[i+1][j];
                if(j != 0) min = Math.min(min, dp[i + 1][j - 1]);
                if(j != n - 1) min = Math.min(min, dp[i + 1][j + 1]);
                dp[i][j] = matrix[i][j] + min;
            }
        }
        int min = dp[0][0];
        // printMatrix(dp);
        for(int d : dp[0]) min = Math.min(min, d);
        return min;
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