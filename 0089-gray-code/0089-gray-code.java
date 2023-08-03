class Solution {
    List<Integer> sol = null;
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        res.add(0);
        seen.add(0);
        backtrack(res , 1 << n , 0 , seen);
        return sol;
    }
    public void backtrack(List<Integer> res , int n , int y  , HashSet<Integer> seen){
        if(sol == null && seen.size() == n ){
            sol = new LinkedList<>(res);
            return;
        }
        for(int i = 0 ; i < 31 && sol == null ; i++){
            int x = y ^ (1 << i);
            if(!seen.contains(x)){
                seen.add(x);
                res.add(x);
                backtrack(res , n , x , seen);
                seen.remove(x);
                res.remove(res.size() - 1);
            }
        }
    }
}