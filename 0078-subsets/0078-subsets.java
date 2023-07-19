class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        backtrack(nums , c , r , 0);
        return r;
    }
    public void backtrack(int[] nums , List<Integer> curr , List<List<Integer>> r , int index){
        r.add(new ArrayList<>(curr));
        if(curr.size() == nums.length) return;
        for(int i = index ; i < nums.length ; i++){
            curr.add(nums[i]);
            backtrack(nums , curr , r , i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}