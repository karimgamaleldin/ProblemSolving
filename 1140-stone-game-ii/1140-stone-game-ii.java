class Solution {
    int[] arr;
    int[][][] memo;
    public int stoneGameII(int[] piles) {
        this.arr = piles;
        int n = arr.length;
        this.memo = new int[n + 1][n + 1][2];
        for(int i = 0 ; i <= n ; i++) for(int j = 0; j <= n ; j++) Arrays.fill(memo[i][j] , -1);
        int t = dp(0 ,0 ,1);
        return t;
    }
    public int dp(int i , int turn , int m){
        if(i >= arr.length) return 0;
        if(memo[i][m][turn] != -1) return memo[i][m][turn];
        int res = turn == 0 ? 0 : Integer.MAX_VALUE;
        int curr = 0;
        for(int x = 1; x <= 2 * m && x <= arr.length - i ; x++){
            curr += arr[i + x - 1];
            if(turn == 0) res = Math.max(res, curr + dp(i + x, 1, Math.max(m, x)));
            else res = Math.min(res, dp(i + x, 0, Math.max(m, x)));
        }
        memo[i][m][turn] = res;
        return res;
    }
    public void print(int[][][] x){
        for(int i = 0 ; i < x.length ; i++){
            for(int j = 0 ; j < x.length ; j++){
                System.out.print("[" + x[i][j][0] + "," + x[i][j][1] +  "] ," );
            }
            System.out.println();
        }
    }
}