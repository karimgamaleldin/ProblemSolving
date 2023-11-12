class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] e: edges){
            if(!map.containsKey(e[0])) map.put(e[0], new ArrayList<>());
            if(!map.containsKey(e[1])) map.put(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        q.add(source);
        seen.add(source);
        while(!q.isEmpty()){
            int node = q.remove();
            List<Integer> l = map.get(node);
            if(l == null) continue;
            for(int a : l){
                if(a == destination) return true;
                if(!seen.contains(a)){
                    q.add(a);
                    seen.add(a);
                }
            }
        }
        return source == destination;
    }
}