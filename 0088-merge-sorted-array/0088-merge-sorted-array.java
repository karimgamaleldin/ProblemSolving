class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while(i >= 0 || j >= 0){
            int x = Integer.MIN_VALUE;
            int f = 0;
            if(i >= 0){
                x = Math.max(x , nums1[i]);
                f = 1;
            }
            if(j >= 0) {
                if(x < nums2[j]){
                    f = 2;
                    x = nums2[j];
                }
            }
            if(f == 1) i--;
            else j--;
            nums1[k--] = x;
        }
    }
}