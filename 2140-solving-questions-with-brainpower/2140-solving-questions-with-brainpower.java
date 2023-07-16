class Solution {
    Map<Integer , Long> memo = new HashMap<>();
    public long mostPoints(int[][] questions) {
        return dp(0 , questions);
    }
    public long dp(int i , int[][] arr){
        if(i >= arr.length) return 0;
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        int j = i + arr[i][1] + 1;
        memo.put(i, Math.max(arr[i][0] + dp(j, arr), dp(i + 1, arr)));
        return memo.get(i);
    }
}