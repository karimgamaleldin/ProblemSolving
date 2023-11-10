class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n != t.length()) return false;
        int[] alph1 = new int[26];
        int[] alph2 = new int[26];
        for(int i = 0 ; i < n ; i++){
            alph1[s.charAt(i) - 'a']++;
            alph2[t.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(alph1[i] != alph2[i]) return false;
        }
        return true;
    }
}