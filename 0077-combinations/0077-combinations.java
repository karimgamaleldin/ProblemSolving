class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<>();
        backtrack(n , k , 1 , r , new ArrayList<>());
        return  r;
        
    }
    public void backtrack(int n , int k , int i ,List<List<Integer>> r , List<Integer> c){
        if(c.size() == k){
            r.add(new ArrayList<>(c));
            return;
        }
        for(int j = i ; j <= n ; j++){
            c.add(j);
            backtrack(n , k , j + 1 , r , c);
            c.remove(c.size() - 1);
        }
    }
}