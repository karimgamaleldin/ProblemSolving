class Solution {
    boolean[][] seen;
    char[][] g;
    public int numIslands(char[][] grid) {
        g = grid;
        int n = grid.length;
        int m = grid[0].length;
        seen = new boolean[n][m];
        int islands = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!seen[i][j] && grid[i][j] == '1'){
                    islands++;
                    seen[i][j] = true;
                    dfs(i , j);
                }
            }
        }
        return islands;
    }
    public void dfs(int i , int j){
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] d : directions){
            int nextRow = i + d[0]; 
            int nextCol = j + d[1];
            if (0 <= nextRow && nextRow < g.length && 0 <= nextCol && nextCol < g[0].length && g[nextRow][nextCol] == '1' && !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                dfs(nextRow, nextCol);
            }
        }
    }
}