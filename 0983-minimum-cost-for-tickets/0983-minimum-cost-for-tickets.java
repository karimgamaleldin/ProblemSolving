class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int m = costs.length;
        int[] dp = new int[days[n - 1] + 1];
        int i = 0;
        for(int j = days[0]; j <= days[n - 1]; j++){
            if(j != days[i]){
                dp[j] = dp[j - 1];
            }else{
                dp[j] = Math.min(dp[j - 1] + costs[0],
                        Math.min(dp[Math.max(j - 7, 0)] + costs[1],
                                dp[Math.max(j - 30, 0)] + costs[2]));
                i++;
            }
        }
        return dp[days[n - 1]];
    }
}