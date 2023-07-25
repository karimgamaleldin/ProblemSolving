class Solution {
    Map<Integer , Integer> map = new HashMap<Integer , Integer>();
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        List<Integer> temp = triangle.get(n - 1);
        for(int i = 0 ; i < n ; i++) dp[i] = temp.get(i);
        for(int i = n - 2 ; i >= 0 ; i--){
            temp = triangle.get(i);
            for(int j = 0 ; j < temp.size() ; j++){
                dp[j] = Math.min(dp[j] , dp[j + 1]) + temp.get(j);
            }
        }
        return dp[0];
    }
}