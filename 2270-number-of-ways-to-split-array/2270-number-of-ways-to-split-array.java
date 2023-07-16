class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] presums = new long[nums.length];
        presums[0] = nums[0];
        int valid = 0;
        for(int i = 1 ; i < nums.length ; i++) presums[i] = presums[i-1] + nums[i];
        for(int i = 0 ; i < nums.length - 1 ; i++){
            if(presums[i] >= presums[nums.length - 1] - presums[i]) valid++;
        }
        return valid;
    }
}