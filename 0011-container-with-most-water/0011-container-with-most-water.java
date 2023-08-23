class Solution {
    public int maxArea(int[] height) {
        // Two pointers from both direction
        int i = 0;
        int j = height.length - 1;
        int max = Math.min(height[i] , height[j]) * j;
        while(i < j){
            if(height[i] < height[j]) i++;
            else j--;
            max = Math.max(Math.min(height[i] , height[j]) * (j - i) , max);
        }
        return max;
    }
}