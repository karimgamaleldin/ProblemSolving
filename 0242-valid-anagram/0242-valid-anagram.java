class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        // bucket sort
        int n = t.length();
        int[] alph = new int[26];
        for(int i = 0 ; i < n; i++){
            alph[t.charAt(i) - 'a']++;
            alph[s.charAt(i) - 'a']--;
        }
        for(int x : alph) if(x != 0) return false;
        return true;
    }
}