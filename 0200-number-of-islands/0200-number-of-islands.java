class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j] && grid[i][j] == '1'){
                    count++;
                    seen[i][j] = true;
                    dfs(i , j , seen , grid);
                }
            }
        }
        return count;
    }
    public void dfs(int i , int j , boolean[][] seen , char[][] g){
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir : directions){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(0 <= newI && newI < g.length && 0 <= newJ && newJ < g[0].length && g[newI][newJ] == '1' && !seen[newI][newJ]){
                seen[newI][newJ] = true;
                dfs(newI , newJ , seen , g);
            }
        }
    }
}