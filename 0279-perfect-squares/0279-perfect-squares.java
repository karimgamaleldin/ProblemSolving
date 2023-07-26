class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            if(checkPerf(i)){
                dp[i] = 1;
                list.addFirst(i);
            }else{
                int count = Integer.MAX_VALUE;
                for(int j = 0 ; j < list.size() ; j++){
                    int temp = i - list.get(j);
                    count = Math.min(count , 1 + dp[temp]);
                }
                dp[i] = count;
            }
        }
        return dp[n];
    }
    public boolean checkPerf(int x){
        return Math.sqrt(x) % 1 == 0;
    }
}