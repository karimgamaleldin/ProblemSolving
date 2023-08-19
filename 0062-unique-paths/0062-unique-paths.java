class Solution {
    public int uniquePaths(int m, int n) {
        int[][] tab = new int[m][n];
        tab[m - 1][n - 1] = 1;
        for(int i = m - 1 ; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0 ; j--){
                int x = 0;
                if(i + 1 != m) x += tab[i + 1][j];
                if(j + 1 != n) x += tab[i][j + 1];
                tab[i][j] += x;
            }
        }
        return tab[0][0];
    }
}