class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = cost[n - 1];
        int b = cost[n - 2];
        for(int i = n - 3; i >= 0 ; i--){
            int temp = b;
            b = Math.min(a , b) + cost[i];
            a = temp;
        }
        return Math.min(a,b);
    }
}