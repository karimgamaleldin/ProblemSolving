class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> r = new ArrayList<>();
        backtrack(r , new ArrayList<>() , k , n , 1 , 0);
        return r;
    }
    public void backtrack( List<List<Integer>> r , List<Integer> curr , int k , int n , int index , int sum){
        if(curr.size() == k){
            if(sum == n) r.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index ; i < 10 ; i++){
            curr.add(i);
            backtrack(r , curr , k , n , i + 1 , sum + i);
            curr.remove(curr.size() - 1);
        }
    }
}