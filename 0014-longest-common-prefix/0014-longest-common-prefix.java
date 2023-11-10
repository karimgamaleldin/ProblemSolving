class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder r = new StringBuilder();
        String s = strs[0];
        for(String x : strs){
            if(s.length() > x.length()) s = x;
        }
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            for(int j = 0 ; j < strs.length; j++){
                if(c != strs[j].charAt(i)) return r.toString();
            }
            r.append(c);
        }
        return r.toString();
    }
}