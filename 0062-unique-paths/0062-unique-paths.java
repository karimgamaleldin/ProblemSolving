class Solution {
    int[][] grid;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        grid = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(grid[i] , -1);
        }
        return dp(0,0);
    }
    public int dp(int i , int j){
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n - 1){
            grid[i][j] = 1;
            return 1;
        }
        if(grid[i][j] != -1){
            return grid[i][j];
        }
        int a = dp(i+1 , j);
        int b = dp(i , j+1);
        int x = a + b;
        grid[i][j] = x;
        return x;
    }
}