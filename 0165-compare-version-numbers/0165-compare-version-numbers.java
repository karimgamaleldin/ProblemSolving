class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int i = 0;
        while(i < a1.length || i < a2.length){
            String x = "0";
            String y = "0";
            if(i < a1.length) x = a1[i];
            if(i < a2.length) y = a2[i];
            int a = Integer.parseInt(x);
            int b = Integer.parseInt(y);
            if(a > b) return 1;
            if(a < b) return -1;
            i++;
        }
        return 0;
    }
}