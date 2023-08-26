class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        int[][] dir = new int[][]{{0 , 1} , {1 , 0} , {-1 , 0} , {0 , -1} , {1 , 1} , {-1 , -1} , {-1 , 1} , {1 , -1}};
        boolean[][] seen = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0 , 0});
        int ans =0;
        while(!q.isEmpty()){
            ans++;
            int s = q.size();
            for(int i = 0 ; i < s ; i++){
                int[] t = q.remove();
                if(t[0] == n - 1 && t[1] == n - 1) return ans;
                for(int[] d : dir){
                    int ni = d[0] + t[0];
                    int nj = d[1] + t[1];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 0 && !seen[ni][nj]){
                        seen[ni][nj] = true;
                        q.add(new int[] {ni , nj});
                    }
                }
            }
        }
        return -1;
    }
}