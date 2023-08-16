class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] tab = new int[n + 1][m + 1];
        for(int i = n - 1 ; i >= 0 ;i--){
            for(int j = m - 1 ; j >= 0 ; j--){
                char c = text1.charAt(i) , d = text2.charAt(j);
                if(c == d) tab[i][j] = 1 + tab[i + 1][j + 1];
                else tab[i][j] = Math.max(tab[i + 1][j] , tab[i][j + 1]);
            }
        }
        return tab[0][0];
    }
    // HashMap<String , Integer> memo = new HashMap<>();
    // String s1;
    // String s2;
    // public int longestCommonSubsequence(String text1, String text2) {
    //     this.s1 = text1;
    //     this.s2 = text2;
    //     return dp(0 , 0);
    // }
    // public int dp(int i , int j){
    //     if(i >= s1.length() || j >= s2.length()) return 0;
    //     else if(memo.containsKey(keyGetter(i , j))) return memo.get(keyGetter(i , j));
    //     char c = s1.charAt(i);
    //     char d = s2.charAt(j);
    //     int t = 0;
    //     if(c == d){
    //         t = dp(i + 1 , j + 1) + 1;
    //     }
    //     else t = Math.max(dp(i + 1 , j) , Math.max(dp(i + 1 , j + 1) , dp(i , j + 1)));
    //     memo.put(keyGetter(i , j) , t);
    //     return t;
    // }
    // public String keyGetter(int i , int j){
    //     return i + " " + j;
    // }
    
}