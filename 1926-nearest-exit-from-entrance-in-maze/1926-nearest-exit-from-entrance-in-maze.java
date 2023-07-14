class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>(); 
        q.add(entrance);
        seen[entrance[0]][entrance[1]] = true;
        int steps = 0;
        while(!q.isEmpty()){
            steps++;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] temp = q.remove();
                for(int[] dir : directions){
                    int newI = dir[0] + temp[0];
                    int newJ = dir[1] + temp[1];
                    if(newI < m && newJ < n && newI >= 0 && newJ >= 0 && maze[newI][newJ] != '+' && !seen[newI][newJ]){
                        if(newI == 0 || newJ == 0 || newI == m - 1 || newJ == n - 1) return steps;
                        seen[newI][newJ] = true;
                        q.add(new int[] {newI,newJ});
                    }
                }
            }
        }
        return -1;
    }
}