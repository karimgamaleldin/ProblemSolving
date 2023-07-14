class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int m = grid.length; int n = grid[0].length;
        if(n == 1 && m == 1) return 0;
        boolean[][] seen = new boolean[m][n]; 
        int[][] removels = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0 , 0 , 0}); // {i , j , removed obstacle}
        seen[0][0] = true;
        removels[0][0] = 0;
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] arr = q.remove();
                for(int[] dir: directions){
                    int newI = arr[0] + dir[0];
                    int newJ = arr[1] + dir[1];
                    if(newI < m && newJ < n && newI >= 0 && newJ >= 0){
                        int newK = arr[2] + grid[newI][newJ];
                        if(newK > k) continue;
                        if(!seen[newI][newJ] || (seen[newI][newJ] && newK < removels[newI][newJ])){ 
                            seen[newI][newJ] = true;
                            removels[newI][newJ] = newK;
                            if(newI == m - 1 && newJ == n - 1) return steps;
                            q.add(new int[]{newI , newJ , newK});
                       }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}