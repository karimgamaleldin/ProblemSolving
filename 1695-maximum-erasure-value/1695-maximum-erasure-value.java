class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        int curr = 0;
        int left = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            curr += nums[i];
            while(set.contains(nums[i])){
                curr -= nums[left];
                set.remove(nums[left++]);
            }
            set.add(nums[i]);
            max = Math.max(max , curr);
        }
        return max;
    }
}