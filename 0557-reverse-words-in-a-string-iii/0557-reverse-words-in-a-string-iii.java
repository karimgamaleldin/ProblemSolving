class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int left = 0;
        int right = 0;
        while(right < n){
            while(right < n && s.charAt(right) != ' '){
                right++;
            }
            int temp = right - 1;
            while(left <= temp){
                char t = c[left];
                c[left] = c[temp];
                c[temp] = t;
                left++;
                temp--;
            }
            right++;
            left = right;
        }
        return new String(c);
    }
}