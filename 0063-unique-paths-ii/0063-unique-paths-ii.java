class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] tab = new int[m][n];
        tab[m - 1][n - 1] = 1;
        for(int i = m - 1; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0 ; j--){
                if(obstacleGrid[i][j] == 1) continue;
                int x = 0;
                if(i != m - 1) x += tab[i + 1][j];
                if(j != n - 1) x += tab[i][j + 1];
                tab[i][j] += x;
            }
        }
        return tab[0][0];
    }
}