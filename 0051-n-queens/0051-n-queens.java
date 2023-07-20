class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> r = new ArrayList<>();
        backtrack(n , r , new ArrayList<>() , 0 , new HashSet<>() , new HashSet<>() , new HashSet<>());
        return r;
    }
    public void backtrack(int n , List<List<String>> r , List<String> curr , int row , HashSet<Integer> column , HashSet<Integer> diag , HashSet<Integer> anti){
        if(n == curr.size()){
            r.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(!column.contains(i) && !diag.contains(row - i) && !anti.contains(row + i)){
                String s = generateQueen(n , i);
                curr.add(s);
                column.add(i);
                diag.add(row - i);
                anti.add(row + i);
                backtrack(n , r , curr , row + 1 , column , diag , anti);
                anti.remove(row + i);
                diag.remove(row - i);
                column.remove(i);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public String generateQueen(int n , int j){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n  ; i++){
            if(i == j) sb.append("Q");
            else sb.append(".");
        }
        return sb.toString();
    }
}