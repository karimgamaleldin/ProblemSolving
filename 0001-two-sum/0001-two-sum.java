class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> m = new HashMap<>();
        int ans[] = new int[]{0,0};
        for(int i = 0 ; i < nums.length ; i++){
            int needed = target - nums[i];
            if(m.containsKey(needed)){
                ans[0] = m.get(needed);
                ans[1] = i;
                break;
            }
            m.put(nums[i] , i);
        }
        return ans;
    }
}