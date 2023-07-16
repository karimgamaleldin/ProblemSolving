class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] r = new int[nums.length];
        int i = nums.length - 1;
        while(left <= right){
            int x = nums[left] * nums[left]; int y = nums[right] * nums[right];
            if(x <= y){
                r[i--] = y;
                right--;
            }else{
                r[i--] = x;
                left++;
            }
        }
        return r;
    }
}