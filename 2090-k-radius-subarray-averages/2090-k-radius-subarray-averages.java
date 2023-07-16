class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0)return nums;
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        int[] avg = new int[nums.length];
        Arrays.fill(avg, -1);
        if(2 * k + 1 > nums.length) return avg;
        for(int i = 1 ; i < nums.length ;i++) prefix[i] = nums[i] + prefix[i - 1];
        for(int i = k ; i < nums.length - k ;i++){
            avg[i] = (int) ((prefix[i + k] - prefix[i - k] + nums[i - k]) / (2 * k + 1));
        }
        return avg;
    }
}