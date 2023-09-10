class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            if(i != 0 && nums[i-1] == nums[i]) continue;
            int target = 0 - nums[i];
            int l = i + 1 , r = nums.length - 1;
            while(l < r){
                int x = nums[l] + nums[r];
                if(x < target){
                    l++;
                }else if(x > target){
                    r--;
                }else{
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[l]);
                    a.add(nums[r]);
                    ans.add(a);
                    while(l < nums.length - 1 && nums[l] == nums[l+1]) l++;
                    while(r > i && nums[r-1] == nums[r]) r--;
                    r--; l++;
                }
            }
        }
        return ans;
    }
}