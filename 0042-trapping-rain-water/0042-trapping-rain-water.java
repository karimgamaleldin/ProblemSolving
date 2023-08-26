class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int left = 0;
        int right = n - 1;
        int lmax = height[0];
        int rmax = height[right];
        while(left < right){
            if(lmax < rmax){
                left++;
                lmax = Math.max(lmax , height[left]);
                water += lmax - height[left];
            }else{
                right--;
                rmax = Math.max(rmax , height[right]);
                water += rmax - height[right];
            }
        }
        return water;
    }
}