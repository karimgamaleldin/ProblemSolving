class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        backtrack(r , c , candidates , target , 0 , 0);
        return r;
    }
    public void backtrack(List<List<Integer>> r ,  List<Integer> c , int[] nums , int t , int sum , int i){
        if(sum > t) return;
        if(sum == t){
            r.add(new ArrayList<>(c));
            return;
        }
        for(; i < nums.length ; i++){
            c.add(nums[i]);
            backtrack(r , c , nums , t , sum + nums[i] , i);
            c.remove(c.size() - 1);
        }
    }
}