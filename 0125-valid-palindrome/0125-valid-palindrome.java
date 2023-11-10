class Solution {
    public boolean isPalindrome(String s) {
        int left = 0; int right = s.length() - 1;
        s = s.toLowerCase();
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(!Character.isLetterOrDigit(l)) left++;
            else if(!Character.isLetterOrDigit(r)) right--;
            else{
                if(l != r) return false;
                left++;
                right--;
            }
        }
        return true;
    }
    
    public boolean check(char l, char r){
        return Math.abs(l - r) == 0 || Math.abs(l - r) == 32;
    }
}