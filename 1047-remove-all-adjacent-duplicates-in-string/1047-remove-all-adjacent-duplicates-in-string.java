class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            char x = s.charAt(i);
            int m = sb.length();
            if(m == 0 || sb.charAt(m - 1) != x) sb.append(x);
            else sb.deleteCharAt(m - 1);
        }
        return sb.toString();
    }
}