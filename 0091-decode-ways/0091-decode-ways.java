class Solution {
    HashMap<Integer , Integer> memo = new HashMap<>();
    String s;
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        this.s = s;
        return dp(0);
    }
    public int dp(int i){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0; 
        if(memo.containsKey(i)) return memo.get(i);
        int a = dp(i + 1);
        int b = i < s.length() - 1 && Integer.parseInt(s.substring(i , i+2)) < 27 ? dp(i + 2) : 0;
        int x = a + b;
        memo.put(i , x);
        return x;
    }
}