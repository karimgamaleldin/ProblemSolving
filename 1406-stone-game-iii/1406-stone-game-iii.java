class Solution {
    int[][] memo;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int sum = 0;
        for(int x: stoneValue) sum += x; 
        this.memo = new int[2][n+1];
        for(int i = 0 ; i < 2 ; i++){
            Arrays.fill(memo[i] , Integer.MIN_VALUE);
        }
        int alice = dp(stoneValue , 0 , 0);
        int bob = sum - alice;
        if(bob == alice) return "Tie";
        if(bob > alice) return "Bob";
        return "Alice";
    }
    public int dp(int[] arr , int i , int turn){
        if(i >= arr.length) return 0;
        if(memo[turn][i] != Integer.MIN_VALUE) return memo[turn][i];
        int res = turn == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int total = 0;
        for(int x = 0 ; x < 3 && i + x < arr.length ; x++){
            total += arr[x + i];
            if(turn == 0) res = Math.max(res , total + dp(arr , i + x + 1 , 1));
            else res = Math.min(res , dp(arr , i + x + 1 , 0));
        }
        memo[turn][i] = res;
        return res;
    }
}