class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[nums1.length];
        int idx = 0;
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j]) j++;
            else if(nums1[i] < nums2[j]) i++;
            else{
                ans[idx++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(ans, idx);
    }
}