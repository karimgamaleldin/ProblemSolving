class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[j] - nums[i] <= k) {
                j++;
                if(j == nums.length){
                    count++;
                }
            }
            else{
                count++;
                i = j;
            }
        }
        return count;
    }
}