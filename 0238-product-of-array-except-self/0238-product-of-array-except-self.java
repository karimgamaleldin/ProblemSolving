class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int p = 1;
        int zeros = 0;
        int zeroIndex = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0) {
                zeros++;
                zeroIndex = i;
            }
            else p*=nums[i];
        }
        if(zeros > 1) return ans;
        else if(zeros == 1){
            ans[zeroIndex] = p;
        }
        else{
            for(int i = 0 ; i < n ; i++){
                ans[i] = p / nums[i];
            }
        }
        return ans;
    }
}