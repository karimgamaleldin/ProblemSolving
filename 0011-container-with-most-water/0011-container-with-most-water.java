class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            int a = height[l];
            int b = height[r];
            int area = Math.min(a,b) * (r - l);
            max = Math.max(max, area);
            if(a < b){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}