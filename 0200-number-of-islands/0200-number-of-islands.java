class Solution {
    int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1' && !seen[i][j]){
                    count++;
                    dfs(grid, seen, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, boolean[][] seen, int i, int j){
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(check(grid, seen, x, y)){
                seen[x][y] = true;
                dfs(grid, seen, x, y);
            }
        }
    }
    
    public boolean check(char[][] grid, boolean[][] seen, int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1' && !seen[i][j]; 
    }
    
}