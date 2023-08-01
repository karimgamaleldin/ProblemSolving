class Solution {
    int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] min = new int[m][n];
        for(int i = 0 ; i < m ; i++) Arrays.fill(min[i] , Integer.MAX_VALUE);
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                   dfs(grid , min , i , j , 0);
                }
            }
        }
        int res = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    int x = min[i][j];
                    if(x == Integer.MAX_VALUE) return -1;
                    res = Math.max(res , x);
                }
            }
        }
        return res;
    }
    public void dfs(int[][] grid , int[][] min , int i , int j , int time){
        int nT = time + 1;
        for(int[] dir : directions){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1 && nT < min[x][y]){
                min[x][y] = nT;
                dfs(grid , min , x , y , nT);
            }
        }
    }
}