class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sol = 0;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            sol = Math.max(sol, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return sol;
    }
}