class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = j;
        int[] result = new int[nums.length];
        while(i <= j){
            int x = nums[i] * nums[i];
            int y = nums[j] * nums[j];
            if(x >= y){
                result[k--] = x;
                i++;
            }
            else{
                result[k--] = y;
                j--;
            }
        }
        return result;
    }
}