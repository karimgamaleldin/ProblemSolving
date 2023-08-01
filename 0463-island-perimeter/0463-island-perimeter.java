class Solution {
    int per = 0;
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] seen = new boolean[row][column];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < column ; j++){
                if(!seen[i][j] && grid[i][j] == 1){
                    dfs(i , j , grid , seen);
                }
            }
        }
        return per;
    }
    public void dfs(int i , int j , int[][] grid , boolean[][] seen){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || seen[i][j])
            return;
        seen[i][j] = true;
        int x = 0;
        if((i + 1 < grid.length && grid[i+1][j] == 0) || i + 1 == grid.length) x++;
        else dfs(i + 1 , j , grid , seen);
        if((i - 1 >= 0 && grid[i-1][j] == 0 )|| i - 1 == -1) x++;
        else dfs(i - 1 , j , grid , seen);
        if((j + 1 < grid[0].length && grid[i][j+1] == 0) || j + 1 == grid[0].length) x++;
        else dfs(i , j + 1 , grid , seen);
        if((j - 1 >= 0 && grid[i][j-1] == 0) || j - 1 == -1) x++;
        else dfs(i , j - 1 , grid , seen);
        per += x;
    }
}