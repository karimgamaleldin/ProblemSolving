class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        int left = 0;
        for(int right = 0; right < nums.length ; right++){
            if(right - left> k){
                set.remove(nums[left]);
                left++;
            }
            if(set.contains(nums[right])) return true;
            set.add(nums[right]);
        }
        return false;
    }
}