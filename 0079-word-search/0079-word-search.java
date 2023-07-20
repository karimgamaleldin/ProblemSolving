class Solution {
    int[][] directions = new int[][]{{0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0}};
    int m = 0;
    int n = 0;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        StringBuilder sb = new StringBuilder();
        HashSet<Pair<Integer , Integer>> s = new HashSet<Pair<Integer , Integer>>();
        boolean solution = false;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                sb.append(board[i][j]);
                Pair p = new Pair(i , j);
                s.add(p);
                solution = solution || backtrack(board , word , sb , 0 , i , j , s);
                sb.delete(sb.length() - 1 , sb.length());
                s.remove(p);
            }
        }
        return solution;
    }
    public boolean backtrack(char[][] board , String word , StringBuilder sb , int letter , int i , int j , HashSet<Pair<Integer , Integer>> set){
        if(sb.charAt(letter) != word.charAt(letter)){
            return false;
        }
        if(sb.length() == word.length()) return true;
        boolean solution = false;
        for(int[] dir : directions){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            Pair<Integer , Integer> p = new Pair<Integer , Integer>(newI , newJ);
            if(newI >= 0 && newJ >= 0 && newI < m && newJ < n && !set.contains(p)){
                set.add(p);
                sb.append(board[newI][newJ]);
                solution = solution || backtrack(board , word , sb , letter + 1 , newI , newJ , set);
                sb.delete(sb.length() - 1 , sb.length());
                set.remove(p);
            }
        }
        return solution;
    }
}