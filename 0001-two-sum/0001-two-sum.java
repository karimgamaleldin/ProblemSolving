class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> h = new HashMap<Integer , Integer>();
        h.put(nums[0] , 0);
        for(int i = 1 ; i < nums.length ; i++){
            int temp = target - nums[i];
            boolean c = h.containsKey(temp);
            if(c){
                int x = h.get(temp);
                return new int[]{x,i};
            }
            h.put(nums[i] , i);
        }
        return new int[]{0,1};
    }
}