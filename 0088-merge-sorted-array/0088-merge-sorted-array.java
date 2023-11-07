class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int oi = m - 1;
        int ti = n - 1;
        int i = m + n - 1;
        while(oi >= 0 || ti >= 0){
            int x = Integer.MIN_VALUE;
            int y = x;
            if(oi >= 0) x = nums1[oi];
            if(ti >= 0) y = nums2[ti];
            nums1[i--] = Math.max(x, y);
            if(x > y) oi--;
            else ti--;
        }
    }
}