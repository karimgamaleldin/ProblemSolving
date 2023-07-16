class Solution {
    public int longestOnes(int[] nums, int k) {
        int zerocount = 0;
        int left = 0;
        int max = 0;
        int curr = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0) zerocount++;
            curr++;
            while(zerocount > k){
                curr--;
                if(nums[left++] == 0)zerocount--;
            }
            max = Math.max(max , curr);
        }
        return max;
    }
}