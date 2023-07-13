class Solution {
    HashMap<Integer , List<Integer>> map = new HashMap<>();
    boolean[] seen;
    int unlocked = 1;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        seen = new boolean[rooms.size()];
        for(int i = 0 ; i < rooms.size() ; i++){
            map.put(i,rooms.get(i));
        }
        seen[0] = true;
        dfs(0);
        return unlocked == rooms.size();
    }
    public void dfs(int n){
        List<Integer> x = map.get(n);
        for(int i = 0 ; i < x.size() ; i++){
            int a = x.get(i);
            if(!seen[a]){
                unlocked++;
                seen[a] = true;
                dfs(a);
            }
        }
    }
}