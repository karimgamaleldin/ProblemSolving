class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length() - 1;
        int count = 0;
        for(int i = n; i >= 0 ; i--){
            char c = s.charAt(i);
            if(c != '-'){
                sb.append(capitalize(c));
                count++;
            }
            if(count == k){
                if(i != 0) sb.append('-');
                count = 0;
            }
        }
        StringBuilder res = sb.reverse();
        while(res.length() > 0 && res.charAt(0) == '-') res.deleteCharAt(0);
        return res.toString();
    }
    public char capitalize(char c){
        if(c < 'a') return c;
        return (char) (c - 32);
    }
}