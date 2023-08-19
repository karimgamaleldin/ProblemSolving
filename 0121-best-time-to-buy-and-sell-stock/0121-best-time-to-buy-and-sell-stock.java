class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProf = Integer.MIN_VALUE;
        for(int i = 0 ; i < prices.length ; i++){
            if(prices[i] < minValue){
                minValue = prices[i];
            }else{
                maxProf = Math.max(maxProf , prices[i] - minValue);
            }
        }
        return maxProf < 0 ? 0 : maxProf;
    }
}