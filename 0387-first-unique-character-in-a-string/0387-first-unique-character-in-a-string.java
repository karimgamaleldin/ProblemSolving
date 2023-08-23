class Solution {
    public int firstUniqChar(String s) {
        int[] alph = new int[26];
        for(char c : s.toCharArray()) alph[c - 'a']++;
        int i = 0;
        for(char c : s.toCharArray()){
            if(alph[c - 'a'] == 1) return i;
            i++;
        }
        return -1;
    }
}