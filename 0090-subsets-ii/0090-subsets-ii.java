class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(r , new ArrayList<>() , nums , 0);
        return r;
    }
    public void backtrack(List<List<Integer>> r , List<Integer> c , int[] nums , int i){
        HashSet<Integer> set = new HashSet<>();
        int s = c.size();
        r.add(new ArrayList<>(c));
        for(; i < nums.length ; i++){
            if(!set.contains(nums[i])){
                c.add(nums[i]);
                backtrack(r , c , nums , i + 1);
                c.remove(c.size() - 1);
                set.add(nums[i]);
            }
        }
    }
}