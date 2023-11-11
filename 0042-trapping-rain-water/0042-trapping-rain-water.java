class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int maxL = height[0];
        int maxR = height[right];
        while(left < right){
            if(maxL < maxR){
                left++;
                maxL = Math.max(maxL, height[left]);
                area += maxL - height[left];
            }else{
                right--;
                maxR = Math.max(maxR, height[right]);
                area += maxR - height[right];
            }
        }
        return area;
    }
}