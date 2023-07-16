class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] tab = new int[amount + 1];
        for(int i = 1 ; i <= amount ; i++){
            tab[i] = amount + 1;
            for(int j = 0 ; j < coins.length ; j++){
                int k = i - coins[j];
                if(k < 0) continue;
                int temp = 1 + tab[k];
                tab[i] = Math.min(temp , tab[i]); 
            }
        }
        return tab[amount] != amount + 1 ? tab[amount] : -1;
    }
}