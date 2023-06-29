class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        boolean change = false;
        do{
            change = false;
            for(int i = 1 ; i < nums.length-1; i++){
                int avg = nums[i-1] + nums[i+1];
                avg = avg/2;
                if(avg == nums[i]){
                    nums[i] ^= nums[i+1];
                    nums[i+1] ^= nums[i];
                    nums[i] ^= nums[i+1];
                    change = true;
                }
            }
        }while(change);
        return nums;
    }
}