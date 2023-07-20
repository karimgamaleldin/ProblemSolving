class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer , HashSet<Character>> c = new HashMap<>(); 
        Map<Pair<Integer , Integer> , HashSet<Character>> b = new HashMap<>();
        for(int i = 0 ; i < 9 ; i++){
            HashSet<Character> r = new HashSet<>();
            int row = i / 3;
            for(int j = 0 ; j < 9 ; j++){
                char ch = board[i][j];
                int column = j / 3;
                if(ch == '.') continue;
                Pair<Integer , Integer> p = new Pair(row , column);
                if(!c.containsKey(j)) c.put(j , new HashSet<>());
                if(!b.containsKey(p)) b.put(p , new HashSet<>());
                if(r.contains(ch) || c.get(j).contains(ch) || b.get(p).contains(ch)) return false;
                r.add(ch);
                c.get(j).add(ch);
                b.get(p).add(ch);
            }
        }
        return true;
    }
}