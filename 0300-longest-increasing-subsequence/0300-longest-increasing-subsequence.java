class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tab = new int[nums.length];
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i - 1; j >= 0 ; j--){
                if(nums[i] > nums[j]) tab[i] = Math.max(tab[i] , tab[j]);
            }
            tab[i]++;
            max = Math.max(tab[i] , max);
        }
        return max;
    }
}