class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int min = 1;
        int n = grid.length;
        if(grid[0][0] == 1) return -1;
        if(n == 1) return 1;
        boolean[][] seen= new boolean[n][n];
        int[][] directions = new int[][]{{0,1} , {1,0} , {1,1} , {-1,0} , {0,-1} , {-1,-1} , {1 , -1} , {-1 , 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] t = q.remove();
                int a = t[0];
                int b = t[1];
                for(int[] dir: directions){
                    int ni = a + dir[0];
                    int nj = b + dir[1];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 0 && !seen[ni][nj]){
                        seen[ni][nj] = true;
                        if(ni == n - 1 && nj == n - 1){System.out.println('h'); return min + 1;}
                        q.add(new int[]{ni , nj});
                    }
                }
            }
            min++;
        }
        return -1;
    }
}