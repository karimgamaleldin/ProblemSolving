class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] seen = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!seen[i][j] && board[i][j] == 'O'){
                    if(checkDfs(board , seen , i , j)){
                        fixDfs(board , i , j);
                    }
                }
            }
        }
    }
    public boolean checkDfs(char[][] board , boolean[][] seen , int i , int j){
        if(i == 0 || j == 0 || i == seen.length - 1 || j == seen[0].length - 1) return false;
        int[][] directions = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        seen[i][j] = true;
        boolean res = true;
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && y >= 0 && x < seen.length && y < seen[0].length && !seen[x][y] && board[x][y] == 'O'){
                res = res & checkDfs(board , seen , x , y);
            }
        }
        return res;
    }
    public boolean fixDfs(char[][] board , int i , int j){
        int[][] directions = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        board[i][j] = 'X';
        boolean res = true;
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'O'){
                res = res & fixDfs(board , x , y);
            }
        }
        return res;
    }
    
}