class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        HashSet<Character> seen = new HashSet<>();
        int n = s.length();
        int ans = 0;
        while(j < n){
            char c = s.charAt(j);
            while(i < j && seen.contains(c)){
                seen.remove(s.charAt(i++));
            }
            seen.add(c);
            ans = Math.max(ans , j - i + 1);
            j++;
        }
        return ans;
    }
}