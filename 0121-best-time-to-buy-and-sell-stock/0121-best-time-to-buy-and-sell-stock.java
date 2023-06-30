class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        for(int i = 0 ; i < prices.length ; i++){
            int currProfit = prices[i] - prices[left];
            if(currProfit < 0){
                while(left <= i && prices[i] - prices[left] < 0) left++;
            }else profit = Math.max(profit , currProfit);
        }
        return profit;
    }
}