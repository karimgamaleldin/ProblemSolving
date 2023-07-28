class Solution {
    int[][][] memo;
    int n;
    int m;
    int[] arr;
    public int maxProfit(int k, int[] prices) {
        arr = prices;
        n = prices.length;
        m = k;
        memo = new int[n][m][2];
        for(int[][] a : memo)
            for(int[] b : a)
                Arrays.fill(b , Integer.MIN_VALUE);
        return dp(0 , k - 1 , 0);
    }
    public int dp(int i , int j , int hold){
        if(i == n || j == -1){
            return 0;
        }else if(memo[i][j][hold] != Integer.MIN_VALUE){
            return memo[i][j][hold];
        }
        int x = dp(i+1 , j , hold);
        if(hold == 0){
            int a = dp(i+1 , j ,1) - arr[i];
            x = Math.max(a , x);
        }else{
            int a = dp(i+1 , j-1 ,0) + arr[i];
            x = Math.max(a,x);
        }
        memo[i][j][hold] = x;
        return x;
    }
}