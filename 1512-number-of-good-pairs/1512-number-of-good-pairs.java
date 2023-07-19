class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer , List<Integer>> indicies = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!indicies.containsKey(nums[i])) indicies.put(nums[i] , new ArrayList<>());
            indicies.get(nums[i]).add(i);
        }
        int ans = 0;
        for(List<Integer> x : indicies.values()){
            int size = x.size();
            ans += (size - 1) * (size) / 2 ;
        }
        return ans;
    }
}