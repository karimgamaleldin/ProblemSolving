class Solution {
    HashMap<Pair<Integer , Integer> , Boolean> memo;
    int[] arr;
    public boolean stoneGame(int[] piles) {
        return true;
        // this.arr = piles;
        // this.memo = new HashMap<>();
        // return dp(0 , piles.length - 1, 0 , 0);
    }
    public boolean dp(int i , int j , int Alice , int Bob){
        Pair<Integer , Integer> key = new Pair(i,j);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(i > j) return false;
        if(i == j){
            return Alice > Bob;
        }
        boolean t = dp(i+1,j-1,Alice + arr[i] , Bob+arr[j]) || dp(i+1,j-1,Alice + arr[j] , Bob+arr[i]) || dp(i+2,j,Alice + arr[i] , Bob+arr[i+1]) || dp(i,j-2,Alice + arr[j] , Bob+arr[j-1]);
        memo.put(key , t);
        return t;
    }
    
}