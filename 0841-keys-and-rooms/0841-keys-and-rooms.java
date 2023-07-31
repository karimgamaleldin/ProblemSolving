class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> seen = new HashSet<>();
        dfs(0,rooms,seen);
        return seen.size() == rooms.size();
    }
    public void dfs(int x , List<List<Integer>> rooms , HashSet<Integer> seen){
        seen.add(x);
        List<Integer> l = rooms.get(x);
        for(int i = 0 ; i < l.size() ; i++){
            if(!seen.contains(l.get(i))){
                dfs(l.get(i) , rooms , seen);
            }
        }
    }
}