class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<>();
        backtrack(n , k , 1 , r , new ArrayList<>());
        return  r;
        
    }
    public void backtrack(int n , int k , int i ,List<List<Integer>> r , List<Integer> c){
        int s = c.size();
        if(s == k) {
            r.add(new ArrayList<>(c));
            return;
        }
        for(; i <= n ; i++){
            c.add(i);
            backtrack(n , k , i + 1 , r , c);
            c.remove(s);
        }
    }
}