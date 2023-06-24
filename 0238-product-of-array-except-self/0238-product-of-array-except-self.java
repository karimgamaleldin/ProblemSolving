class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numZ = 0;
        int p = 1;
        int[] r = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0) numZ++;
            if (numZ > 1) return r;
            if(nums[i] != 0) p *= nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(numZ == 1 && nums[i] == 0) r[i] = p;
            else if(numZ == 1) r[i] = 0;
            else r[i] = p / nums[i]; 
        }
        return r;
    }
}