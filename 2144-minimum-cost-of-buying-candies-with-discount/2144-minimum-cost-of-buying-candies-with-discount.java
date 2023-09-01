class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        int skip = 0;
        for(int i = cost.length - 1 ; i >= 0 ; i--){
            skip++;
            if(skip % 3 == 0) continue;
            ans += cost[i];
        }
        return ans;
    }
}