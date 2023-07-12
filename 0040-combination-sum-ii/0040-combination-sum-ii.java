class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates , target , r , new ArrayList<>() , 0 , 0);
        return r;
    }
    public void backtrack(int[] nums , int t , List<List<Integer>> r ,  List<Integer> c , int i,  int sum){
        if(sum > t) return;
        if(sum == t){
            r.add(new ArrayList<>(c));
            return;
        }
        for(int j = i; j < nums.length ; j++){
            if(i != j && nums[j - 1] == nums[j]) continue;
            c.add(nums[j]);
            backtrack(nums , t , r , c , j + 1 , sum + nums[j]);
            c.remove(c.size() - 1);
        }
    }
}