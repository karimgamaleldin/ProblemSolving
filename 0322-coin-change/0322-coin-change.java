class Solution {
    public int coinChange(int[] coins, int amount) {
        int size = amount + 1;
        int[] tab = new int[size];
        tab[0] = 0;
        for(int i = 0 ; i < coins.length && coins[i] <= amount ; i++) tab[coins[i]] = 1;
        for(int i = 1 ; i <= amount ; i++){
            tab[i] = Integer.MAX_VALUE; // To know if not possible
            for(int coin : coins){
                int x = i - coin;
                if(x < 0) continue;
                if(tab[x] != Integer.MAX_VALUE){
                    tab[i] = Math.min(tab[x] + 1 , tab[i]);
                }
            }
        }
        return tab[amount] != Integer.MAX_VALUE ? tab[amount] : -1;
    }
}