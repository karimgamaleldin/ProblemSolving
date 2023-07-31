class Solution {
    public boolean isMatch(String s, String p) {
        HashMap<Pair<Integer,Integer> , Boolean> memo = new HashMap<>();
        return dp(0, 0  , s , p , memo);
    }
    public boolean dp(int i, int j , String s , String p , HashMap<Pair<Integer,Integer> , Boolean> memo) {
        if(i >= s.length() && j >= p.length()) return true; // both string and expression finished
        if(j >= p.length()) return false; // expression finished while string didnot finish
        Pair<Integer , Integer> key = new Pair(i,j);
        if(memo.containsKey(key)) return memo.get(key);
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            boolean temp = match && dp(i+1,j,s,p,memo) || dp(i,j+2,s,p,memo);
            memo.put(key , temp);
            return temp;
        }else if(match){
            boolean temp = dp(i+1,j+1,s,p,memo);
            memo.put(key,temp);
            return temp;
        }
        memo.put(key , false);
        return false;
    }
}
