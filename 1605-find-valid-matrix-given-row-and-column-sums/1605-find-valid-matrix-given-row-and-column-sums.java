class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] mat = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            int x = rowSum[i];
            for(int j = 0 ; j < m ; j++){
                int y = colSum[j];
                int min = Math.min(x, y);
                mat[i][j] = min;
                x -= min;
                colSum[j] -= min;
            }
        }
        return mat;
    }
}