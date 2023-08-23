class Solution {
    public int strStr(String haystack, String needle) {
        int sol = -1;
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0 ; i < n ; i++){
            int j = 0;
            int k = i;
            while(j < m && k < n && needle.charAt(j) == haystack.charAt(k)){
                j++;
                k++;
            }
            if(j == m) return i;
        }
        return sol;
    }
}