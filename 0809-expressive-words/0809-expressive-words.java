class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for(String w : words){
            if(checkExp(s, w)){
                count++;
            }
        }
        return count;
    }
    
    public boolean checkExp(String s, String w){
        int i = 0;
        int j = 0;
        while(i < s.length() && j < w.length()){
            char c = s.charAt(i);
            char y = w.charAt(j);
            if(c != y) return false;
            int a = getRep(s, c, i);
            int b = getRep(w, y, j);
            if(a < 3 && a != b || a >= 3 && a < b){
                return false;
            }
            i += a;
            j += b;
        }
        return i == s.length() && j == w.length();
    }
    
    public int getRep(String s, char c, int i){
        int count = 0;
        while(i < s.length() && s.charAt(i) == c){
            count++;
            i++;
        }
        return count;
    }
}