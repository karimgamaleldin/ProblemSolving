class Solution {
    public boolean winnerSquareGame(int n) {
        Map<Integer , Boolean> memo = new HashMap<Integer , Boolean>();
        memo.put(0 , false);
        return dp(memo , n);
    }
    public boolean dp(Map<Integer , Boolean> memo , int n){
        if(memo.containsKey(n)) return memo.get(n);
        int x = (int) (Math.sqrt(n));
        for(int i = 1 ; i <= x ; i++){
            int a = n - i * i;
            if(!dp(memo , a)){
                memo.put(n , true);
                return true;
            }
        }
        memo.put(n,false);
        return false;
    }   
}