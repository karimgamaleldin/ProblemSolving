class Solution {
    // Map<Integer , Integer> memo = new HashMap<>();
    // int[] arr;
    public int minCostClimbingStairs(int[] cost) {
        int[] tab = new int[cost.length + 1];
        for(int i = 2 ; i < tab.length ; i++){
            tab[i] = Math.min(cost[i - 1] + tab[i - 1] , cost[i - 2] + tab[i - 2]);
        }
        return tab[tab.length - 1];
    }
//     public int minCostClimbingStairsBottomUp(int[] cost) {
//         arr = cost;
//         dp(cost.length);
//         return memo.get(cost.length);
//     }
    
//     public int dp(int i){
//         if(i == 0 || i == 1){
//             return 0;
//         }
//         else{
//             if(!memo.containsKey(i)) memo.put(i , Math.min(dp(i-1) + arr[i-1] , dp(i-2) + arr[i-2]));
//             return memo.get(i);
//         }
//     }
}