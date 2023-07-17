class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int count = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] % 2 == 1) count++;
            int t = count - k;
            ans += map.getOrDefault(t , 0);
            map.put(count , map.getOrDefault(count , 0) + 1);
        }
        return ans;
    }
}