class Solution {
    HashMap<String , Integer> memo = new HashMap<>();
    String s1;
    String s2;
    public int longestCommonSubsequence(String text1, String text2) {
        this.s1 = text1;
        this.s2 = text2;
        return dp(0 , 0);
    }
    public int dp(int i , int j){
        if(i >= s1.length() || j >= s2.length()) return 0;
        else if(memo.containsKey(keyGetter(i , j))) return memo.get(keyGetter(i , j));
        char c = s1.charAt(i);
        char d = s2.charAt(j);
        int t = 0;
        if(c == d){
            t = dp(i + 1 , j + 1) + 1;
        }
        else t = Math.max(dp(i + 1 , j) , Math.max(dp(i + 1 , j + 1) , dp(i , j + 1)));
        memo.put(keyGetter(i , j) , t);
        return t;
    }
    public String keyGetter(int i , int j){
        return i + " " + j;
    }
    
}