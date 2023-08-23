class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> m = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int x = target - nums[i];
            if(m.containsKey(x)){
                return new int[] {m.get(x) , i};
            }
            m.put(nums[i] , i);
        }
        return null;
    }
}