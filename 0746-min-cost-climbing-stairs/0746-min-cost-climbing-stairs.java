class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[cost.length - 1] = cost[cost.length -1];
        minCost[cost.length - 2] = cost[cost.length - 2];
        for(int i = cost.length - 3; i >= 0 ; i--){
            int minNextJump = Math.min(minCost[i+1] , minCost[i+2]);
            minCost[i] = minNextJump + cost[i];
        }
        return minCost[0] > minCost[1] ? minCost[1] : minCost[0];
    }
}