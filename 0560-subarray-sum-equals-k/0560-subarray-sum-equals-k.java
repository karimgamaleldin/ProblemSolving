class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int curr = 0;
        int ans = 0;
        for(int i = 0 ;  i < n ; i++){
            curr += nums[i];
            int t = curr - k;
            ans += map.getOrDefault(t , 0);
            map.put(curr , map.getOrDefault(curr , 0) + 1);
        }
        return ans;
    }
}