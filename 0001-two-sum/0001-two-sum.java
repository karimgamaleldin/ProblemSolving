class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            int n = nums[i];
            int x = target - n;
            if(map.containsKey(x)) return new int[] {map.get(x) , i};
            map.put(n, i);
        }
        return null;
    }
}