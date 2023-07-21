class Solution {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            int m = sb.length();
            if(c == '*'){
                if(m > 0) sb.deleteCharAt(m - 1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}