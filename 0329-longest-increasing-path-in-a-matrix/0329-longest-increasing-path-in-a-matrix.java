class Solution {
    static int[][] dir = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for(int[] me : memo){
            Arrays.fill(me, -1);
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                HashSet<String> seen = new HashSet<>();
                int k = dfs(matrix, i, j, memo, seen);
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int i, int j, int[][] memo, HashSet<String> seen){
        if(memo[i][j] != -1) return memo[i][j];
        int sol = 0;
        for(int[] d : dir){
            int x = d[0] + i;
            int y = d[1] + j;
            if(x >= 0 && y >= 0 && x < memo.length && y < memo[0].length && !seen.contains(x+","+y) && matrix[x][y] > matrix[i][j]){
                seen.add(x+","+y);
                int z = dfs(matrix, x, y, memo, seen);
                sol = Math.max(sol, z);
                seen.remove(x+","+y);
            }
        }
        memo[i][j] = sol + 1;
        return sol + 1;
    }
}