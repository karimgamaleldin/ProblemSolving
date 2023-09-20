class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        while(l < r){
            char c = s.charAt(l);
            char d = s.charAt(r);
            if(!Character.isLetterOrDigit(c)){
                l++;
            }
            else if(!Character.isLetterOrDigit(d)){
                r--;
            }
            else if(check(c, d)){
                l++;
                r--;
            }
            else return false;
        }
        return true;
        
    }
    public boolean check(char a, char b){
        int x = Math.abs(a - b);
        return x == 0 || x == 32;
    }
}