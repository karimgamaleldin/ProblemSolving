class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean dp[] = new boolean[n + 1];
        dp[n] = true;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                String s2 = s.substring(i, j + 1);
                if(dict.contains(s2) && dp[j + 1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    
}