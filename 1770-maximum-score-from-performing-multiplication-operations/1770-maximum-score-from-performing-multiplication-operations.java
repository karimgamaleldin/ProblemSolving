class Solution {
    public int maximumScore(int[] nums , int[] multipliers){
        int n = nums.length;
        int m = multipliers.length;
        int[][] tab = new int[m + 1][m + 1];
        for(int[] me : tab) Arrays.fill(me , 0);
        for(int i = m - 1 ; i >= 0 ; i--){
            for(int j = i; j >= 0 ; j--){
                int start = multipliers[i] * nums[j] + tab[i + 1][j + 1]; 
                int end   = multipliers[i] * nums[n - 1 - (i - j)] + tab[i + 1][j]; 
                tab[i][j] = Math.max(start , end);
            }
        }
        return tab[0][0];
    }
    // // Bottom UP
    // HashMap<String , Integer> memo = new HashMap<>();
    // int[] nums;
    // int[] multipliers;
    // public int maximumScore(int[] nums, int[] multipliers) {
    //     int n = nums.length;
    //     int m = multipliers.length;
    //     this.nums = nums;
    //     this.multipliers = multipliers;
    //     return dp(0 , n - 1 , 0);
    // }
    // public int dp(int i , int j , int m){
    //     if(i > j || m == multipliers.length) return 0;
    //     else if(memo.containsKey(keyMap(i , j , m))) return memo.get(keyMap(i , j , m));
    //     int start = nums[i] * multipliers[m] + dp(i + 1 , j , m + 1);
    //     int end   = nums[j] * multipliers[m] + dp(i , j - 1 , m + 1);
    //     int x = Math.max(start , end);
    //     memo.put(keyMap(i , j , m) , x);
    //     return x;
    // }
    // public String keyMap(int i , int j , int m){
    //     return "" + i + " " + j + " " + m;
    // }
}