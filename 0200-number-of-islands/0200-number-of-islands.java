class Solution {
    static int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int ans = 0;
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!seen[i][j] && grid[i][j] == '1'){
                    seen[i][j] = true;
                    dfs(seen, grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void dfs(boolean[][] seen, char[][] grid, int i, int j){
        for(int[] d: dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && y >= 0 && x < seen.length && y < seen[0].length && !seen[x][y] && grid[x][y] == '1'){
                seen[x][y] = true;
                dfs(seen, grid, x, y);
            }
        }
    }
    
}