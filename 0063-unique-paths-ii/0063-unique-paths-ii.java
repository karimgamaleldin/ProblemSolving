class Solution {
    int[][] memo;
    int[][] grid;
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        grid = obstacleGrid;
        memo = new int[m][n];
        for(int i = 0 ; i < m ; i++) Arrays.fill(memo[i] , -1);
        return dp(0,0);
    }
    public int dp(int i , int j){
        if(i == m || j == n || grid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        if(memo[i][j] != -1) return memo[i][j];
        int x = dp(i , j+1) + dp(i+1 , j);
        memo[i][j] = x;
        return x;
    }
}