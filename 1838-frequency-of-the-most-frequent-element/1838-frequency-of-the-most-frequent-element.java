class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = nums.length - 1;
        int freq = 0;
        while(left >= 0){
            int num = nums[left];
            int kk = k;
            int f = 0;
            int next = -1;
            while(left >= 0 && kk > 0){
                if(num == nums[left]){
                    f++;
                }
                else{
                    if(next == -1) next = left;
                    int j = num - nums[left];
                    if(kk >= j)
                        f++;
                    kk -= j;
                }
                left--;
            }
            left = next;
            freq = Math.max(freq , f);
        }
        return freq;
    }
}