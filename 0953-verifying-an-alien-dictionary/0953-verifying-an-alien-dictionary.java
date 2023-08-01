class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for(int i = 0 ; i < 26 ; i++) map[order.charAt(i) - 'a'] = i;
        for(int i = 0 ; i < words.length - 1 ; i++){
            if(!compare(words[i] , words[i + 1] , map)) return false;
        }
        return true;
    }
    public boolean compare(String a , String b ,  int[] map){
        int x = Math.min(a.length() , b.length());
        for(int i = 0 ; i < x ; i++){
            char c = a.charAt(i);
            char d = b.charAt(i);
            int e = map[c - 'a'];
            int f = map[d - 'a'];
            if(e < f) return true;
            if(e > f) return false;
        }
        if (b.length() < a.length()) return false;
        return true;
    }
}