class Solution {
    boolean[][] seen;
    int[][] vals;
    public int[][] updateMatrix(int[][] mat) {
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int m = mat.length;
        int n = mat[0].length;
        seen = new boolean[m][n];
        vals = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i , j});
                    seen[i][j] = true;
                }
            }
        }
        int x = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0 ; i < s ; i++){
                int[] temp = q.remove();
                vals[temp[0]][temp[1]] = x;
                for(int[] dir : directions){
                    int newI = temp[0] + dir[0];
                    int newJ = temp[1] + dir[1];
                    if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && !seen[newI][newJ]){
                        seen[newI][newJ] = true;
                        q.add(new int[] {newI , newJ});
                    }
                }
            }
            x++;
        }
        return vals;
    }
}