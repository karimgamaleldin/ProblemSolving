class Solution {
    public int maxProfit(int[] prices) {
        int best = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min) min = prices[i];
            else best = Math.max(best, prices[i] - min);
        }
        return best;
    }
}