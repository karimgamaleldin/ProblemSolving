class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] arr = new int[r + 1];
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            int x = 0;
            if(Math.abs(nums[l]) < Math.abs(nums[r])){
                x = Math.abs(nums[r]);
                r--;
            }else{
                x = Math.abs(nums[l]);
                l++;
            }
            arr[i] = x * x; 
        }
        return arr;
    }
}