class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j] && grid[i][j] == 1){
                    int[] v = new int[1];
                    boolean f = dfs(i , j , grid , seen , v);
                    if(f){
                        count += v[0];
                    }
                }
            }
        }
        return count;
    }
    public boolean dfs(int i  , int j , int[][] grid , boolean[][] seen , int[] v){
        if(seen[i][j] || grid[i][j] == 0) return true;
        if(i == 0 || j == 0 || i == grid.length - 1|| j == grid[0].length - 1) return false;
        seen[i][j] = true;
        v[0]++;
        return dfs(i+1,j,grid,seen , v) & dfs(i-1,j,grid,seen,v) & dfs(i,j+1,grid,seen,v) & dfs(i,j-1,grid,seen,v);
    }
}