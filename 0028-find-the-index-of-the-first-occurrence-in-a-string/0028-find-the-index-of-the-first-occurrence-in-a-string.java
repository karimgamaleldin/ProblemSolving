class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0 ; i < n; i++){
            int j = i;
            int k = 0;
            while(k < m && j < n && haystack.charAt(j) == needle.charAt(k)){
                k++;
                j++;
            }
            if(k == m) return i;
        }
        return -1;
    }
}