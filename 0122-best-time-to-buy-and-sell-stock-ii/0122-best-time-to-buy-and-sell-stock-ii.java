class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] tab = new int[n + 1][2];
        for(int i = n - 1 ; i >= 0; i--){
            tab[i][0] = Math.max(tab[i + 1][1] - prices[i], tab[i + 1][0]);
            tab[i][1] = Math.max(tab[i + 1][0] + prices[i], tab[i + 1][1]);
        }
        return tab[0][0];
    }
}