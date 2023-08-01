class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        boolean[][] seen = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j] && grid2[i][j] == 1 && dfs(i , j , grid1 , grid2 , seen)){
                    count += 1;
                }
            }
        }
        return count;
    }
    public boolean dfs(int i , int j , int[][] g1 , int[][] g2 , boolean[][] s){
        if(i < 0 || j < 0 || i >= g1.length || j >= g1[0].length || g2[i][j] == 0 || s[i][j]) return true;
        if(g1[i][j] == 0) return false;
        s[i][j] = true;
        boolean res = true;
        res = res & dfs(i + 1 , j , g1 , g2 , s) & dfs(i - 1 , j , g1 , g2 , s) & dfs(i , j + 1 , g1 , g2 , s) & dfs(i , j - 1 , g1 , g2 , s);
        return res;
    }
}