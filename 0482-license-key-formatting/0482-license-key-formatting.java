class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int n = s.length() - 1;
        for(int i = n; i >= 0; i--){
            char c = s.charAt(i);
            if(c == '-') continue;
            if(count == k){
                count = 0;
                sb.insert(0, '-');
            }
            sb.insert(0, c);
            count++;
        }
        return sb.toString();
    }
}