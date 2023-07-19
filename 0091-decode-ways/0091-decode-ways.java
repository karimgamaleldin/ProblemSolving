class Solution {
    /*
    Let's assume we take the first character
    we can take it or leave it
    then we can build on the the previous values by either taking it or leaving it.
    */
    HashMap<Integer , Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return dp(s , 0);
    }
    public int dp(String s , int i){
        if(memo.containsKey(i)) return memo.get(i);
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(i == s.length() - 1) return 1;
        int a = dp(s , i + 1); // take the next
        int b = Integer.parseInt(s.substring(i , i + 2)) < 27 ? dp(s , i + 2) : 0 ; // skip one point
        memo.put(i , a + b);
        return a + b;
    }
}