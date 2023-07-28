class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                int j = i;
                while(j < nums.length && nums[j] == 0){
                    j++;
                }
                count += ((long) j - i)*((long) j - i + 1) / 2;
                i = j - 1;
            }
        }
        return count;
    }
}