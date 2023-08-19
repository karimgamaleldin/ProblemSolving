class Solution {
    HashSet<String> dict;
    String s;
    int n;
    HashMap<Integer , Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dict = new HashSet<>(wordDict);
        this.s = s;
        this.n = s.length();
        return dp(0);
    }
    public boolean dp(int i){
        if(i == n) return true;
        if(memo.containsKey(i)) return memo.get(i);
        boolean f = false;
        for(int j = i ; j < n ; j++){
            String t = s.substring(i , j + 1);
            if(dict.contains(t)){
                boolean f2 = dp(j + 1);
                if(f2){
                    f = true;
                    break;
                }
            }
        }
        memo.put(i , f);
        return f;
    }
    
}