class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int n = s.length();
        int l = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            while(seen.contains(c)){
                char d = s.charAt(l++);
                seen.remove(d);
            }
            seen.add(c);
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}