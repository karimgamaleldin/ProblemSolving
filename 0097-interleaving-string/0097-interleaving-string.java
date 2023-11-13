class Solution {
    HashMap<String, Boolean> memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        this.memo = new HashMap<>();
        return dp(0, 0, s1, s2, s3);
    }
    
    public boolean dp(int i, int j, String s1, String s2, String s3){
        if(i == s1.length() && j == s2.length()) return true;
        String key = getKey(i, j);
        if(this.memo.containsKey(key)) return this.memo.get(key);
        boolean f = false;
        char c = s3.charAt(i + j);
        if(i < s1.length() && s1.charAt(i) == c) f |= dp(i + 1, j, s1, s2, s3);
        if(j < s2.length() && s2.charAt(j) == c) f |= dp(i, j + 1, s1, s2, s3);
        this.memo.put(key, f);
        return f;
    }
    
    public String getKey(int i, int j){
        return i + "," + j;
    }
}