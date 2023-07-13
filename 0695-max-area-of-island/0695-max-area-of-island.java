class Solution {
    boolean[][] seen;
    int max = 0;
    int curr = 0;
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j] && grid[i][j] == 1){
                    curr++;
                    seen[i][j] = true;
                    dfs(i , j , grid);
                    max = Math.max(max , curr);
                    curr = 0;
                }
            }
        }
        return max;
    }
    public void dfs(int i , int j , int[][] grid){
        int[][] directions = new int[][]{{0,1} , {1,0} , {-1,0} , {0,-1}};
        for(int[] dir : directions){
            int ci = i + dir[0];
            int cj = j + dir[1];
            if(check(ci , cj , grid) && !seen[ci][cj]){
                curr++;
                seen[ci][cj] = true;
                dfs(ci , cj , grid);
            }
        }
    }
    public boolean check(int i , int j , int[][] grid){
        return i >= 0 && i <m && j >= 0 && j < n && grid[i][j] == 1;
    }
}