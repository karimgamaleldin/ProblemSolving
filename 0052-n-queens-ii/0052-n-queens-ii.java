class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> diagonals = new HashSet<>();
        HashSet<Integer> anti = new HashSet<>();
        backtrack(n , 0 , columns , diagonals , anti);
        return result;
    }
    public void backtrack(int n , int r , HashSet<Integer> columns , HashSet<Integer> diagonals , HashSet<Integer> anti){        
        if(r == n){
            result++;
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(!columns.contains(i) && !diagonals.contains(r - i) && !anti.contains(r + i)){
                columns.add(i);
                diagonals.add(r - i);
                anti.add(r + i);
                backtrack(n , r + 1 , columns , diagonals , anti);
                columns.remove(i);
                diagonals.remove(r - i);
                anti.remove(r + i);
            }
        }
    }
}