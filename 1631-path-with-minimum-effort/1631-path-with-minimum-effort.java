class Solution {
    static class Point{
        int x;
        int y;
        public Point(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    // Bellman ford
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dp = new int[m][n];
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d : dp) Arrays.fill(d , Integer.MAX_VALUE);
        dp[0][0] = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0 , 0));
        HashSet<Point> set = new HashSet<>();
        while(!q.isEmpty()){
            Point p = q.remove();
            for(int[] d : dir){
                int i = d[0] + p.x;
                int j = d[1] + p.y;
                if(i >= 0 && j >= 0 && i < m && j < n){
                    int c = dp[p.x][p.y];
                    int temp = Math.max(dp[p.x][p.y] , Math.abs(heights[i][j] - heights[p.x][p.y]));
                    // System.out.println(temp);
                    if(temp < dp[i][j]){
                        dp[i][j] = temp;
                        // System.out.println(i +"," +j +"=" + dp[i][j]);
                        Point pt = new Point(i , j);
                        if(!set.contains(pt)){
                            q.add(pt);
                            set.add(pt);
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
        
    }
}