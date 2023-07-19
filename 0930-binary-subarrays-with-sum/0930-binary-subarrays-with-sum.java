class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>(); // for prefix count
        map.put(0 , 1);
        int ans = 0;
        int curr = 0;
        for(int i = 0 ; i < n ; i++){
            int x = nums[i];
            curr += x;
            int t = curr - goal;
            ans += map.getOrDefault(t , 0);
            map.put(curr , map.getOrDefault(curr , 0) + 1);
        }
        return ans;
    }
}