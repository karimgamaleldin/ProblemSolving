class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[amount + 1][coins.length];
        for(int[] me : memo) Arrays.fill(me, -1);
        return dp(amount, 0, memo, coins);
    }
    
    public int dp(int amount, int index, int[][] memo, int[] coins){
        if(index >= coins.length || amount < 0) return 0;
        if(amount == 0) return 1;
        if(memo[amount][index] != -1) return memo[amount][index];
        int total = 0;
        for(int i = index; i < coins.length ; i++){
            total += dp(amount - coins[i], i, memo, coins);   
        }
        memo[amount][index] = total;
        return total;
    }
}