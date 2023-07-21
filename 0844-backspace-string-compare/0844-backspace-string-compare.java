class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        StringBuilder ss = new StringBuilder();
        StringBuilder st = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            char x = s.charAt(i);
            if(x != '#') ss.append(x);
            else if(ss.length() != 0) ss.deleteCharAt(ss.length() - 1);
        }
        for(int i = 0 ; i < m ; i++){
            char x = t.charAt(i);
            if(x != '#') st.append(x);
            else if(st.length() != 0) st.deleteCharAt(st.length() - 1);
        }   
        return ss.toString().equals(st.toString());
    }
}