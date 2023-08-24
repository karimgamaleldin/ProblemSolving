class Solution {
    boolean f = false;
    int[][] directions = new int[][]{{0,1} , {1,0} , {-1,0} , {0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0 ; i < m && !f ; i++){
            for(int j = 0 ; j < n && !f ; j++){
                if(board[i][j] == word.charAt(0)){
                    HashSet<String> seen = new HashSet<>();
                    seen.add(i + " " + j);
                    backtrack(board , word , 1 , i , j , seen);
                }
            }
        }
        return f;
    }
    public void backtrack(char[][] b , String w , int k , int i , int j , HashSet<String> seen){
        if(k == w.length()){
            f = true;
            return;
        }
        
        for(int[] dir: directions){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && nj >= 0 && ni < b.length && nj < b[0].length && !seen.contains(ni + " " + nj) && b[ni][nj] == w.charAt(k)){
                seen.add(ni + " " + nj);
                backtrack(b , w , k + 1 , ni , nj , seen);
                seen.remove(ni + " " + nj);
            }
            if(f) break;
        }
        
    }
}