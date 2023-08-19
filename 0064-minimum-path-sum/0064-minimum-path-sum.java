class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tab = new int[m][n];
        tab[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int i = m - 1; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0 ; j--){
                if(i == m - 1 && j == n - 1) continue;
                int x = Integer.MAX_VALUE;
                if(i != m - 1) x = Math.min(x , tab[i+1][j]);
                if(j != n - 1) x = Math.min(x , tab[i][j+1]);
                tab[i][j] = x + grid[i][j];
            }
        }
        return tab[0][0];
    }
}