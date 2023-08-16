class Solution {
    int[][] memo;
    int[] arr;
    int[] h;
    int d;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        this.d = d;
        if(n < d) return -1;
        if(n == d){
            int total = 0;
            for(int i = 0 ; i < n ; i++)
                total += jobDifficulty[i];
            return total;
        }
        this.h = new int[n];
        h[n - 1] = jobDifficulty[n - 1];
        for(int i = n - 2; i >= 0 ; i--) h[i] = Math.max(jobDifficulty[i] , h[i+1]);
        this.arr = jobDifficulty;
        memo = new int[n + 1][d + 1];
        for(int[] m : memo) Arrays.fill(m , -1);
        return dp(0 , 1);
    }
    private int dp(int i, int day) {
        if (day == d) {
            return h[i];
        }
        
        if (memo[i][day] != -1) return memo[i][day];
        int best = Integer.MAX_VALUE;
        int hardest = 0;
        for (int j = i; j < arr.length - (d - day); j++) {
            hardest = Math.max(hardest, arr[j]);
            best = Math.min(best, hardest + dp(j + 1, day + 1));
        }
        memo[i][day] = best;
        return memo[i][day];
    }
    
}