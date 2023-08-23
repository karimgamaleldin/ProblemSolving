class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int sign = 1;
        int ans = 0;
        int i = 0;
        while(i < n && s.charAt(i) == ' ')i++;
        if(i < n){
            char c = s.charAt(i);
            if(c == '-' || c == '+'){
                sign = c == '-' ? -1 : 1;
                i++;
            }
        }
        while(i < n && Character.isDigit(s.charAt(i))){
            int c = s.charAt(i) - '0';
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && c  > Integer.MAX_VALUE % 10)){
                return sign == -1? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + c;
            i++;
        }
        return ans * sign;
    }
}