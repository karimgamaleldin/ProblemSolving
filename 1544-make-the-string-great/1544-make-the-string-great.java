class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            int m = sb.length();
            if(m == 0 || !compare(c , sb.charAt(m - 1))) sb.append(c);
            else sb.deleteCharAt(m - 1);
        }
        return sb.toString();
    }
    public boolean compare(char s , char l){
        return Math.abs(s - l) == 32;
    }
    
}