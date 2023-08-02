class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int t = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j] && grid[i][j] == 0 && dfs(i,j,grid,seen)){
                    t++;
                }
            }
        }
        return t;
    }
    public boolean dfs(int i , int j , int[][] grid , boolean[][] seen){
        if(grid[i][j] == 1 || seen[i][j]) return true;
        if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) return false;
        seen[i][j] = true;
        return dfs(i+1,j,grid,seen) & dfs(i-1,j,grid,seen) & dfs(i,j-1,grid,seen) & dfs(i,j+1,grid,seen);
    }
}