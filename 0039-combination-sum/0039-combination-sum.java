class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<>();
        backtrack(candidates , target , 0 , r , new ArrayList<>() , 0);
        return r;
    }
    public void backtrack(int[] candidates , int target , int sum , List<List<Integer>> r , List<Integer> c , int j){
        if(sum >= target){
            if(sum == target) r.add(new ArrayList<>(c));
            return;
        }
        for(int i = j ; i < candidates.length ; i++){
            c.add(candidates[i]);
            backtrack(candidates , target , sum + candidates[i] , r , c , i);
            c.remove(c.size() - 1);
        }
    }
}