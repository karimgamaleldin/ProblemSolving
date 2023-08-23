class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // similar to 2 sum but we need a target to be 0 and we will make an extra loop
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(i != 0 && nums[i - 1] == nums[i]) continue;
            int target = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int x = nums[j] + nums[k];
                if(target == x){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    ans.add(l);
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(k > j && nums[k] == nums[k-1]) k--;
                    k--;
                    j++;
                }else if(x > target) k--;
                else j++;
            }
        }
        return ans;
    }
}