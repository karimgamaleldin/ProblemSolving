class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        Map<Integer , List<Integer>> graph = new HashMap<>();
        for(int[] p : prerequisites){
            if(!graph.containsKey(p[1])) graph.put(p[1] , new LinkedList<>());
            graph.get(p[1]).add(p[0]);
        }
        // System.out.println(graph);
        boolean res = true;
        boolean[] seen = new boolean[numCourses];
        boolean[] completed = new boolean[numCourses];
        for(int num : graph.keySet()){
            if(completed[num]) continue;
            seen[num] = true;
            res = res && dfs(graph , seen , num , completed);
            seen[num] = false;
            if(!res) break;
        }
        return res;
    }
    public boolean dfs(Map<Integer , List<Integer>> graph, boolean[] seen , int num , boolean[] completed){
        if(completed[num]) return true;
        List<Integer> next = graph.get(num);
        boolean cycle = true;
        for(int i = 0 ; cycle && i < next.size() ;i++){
            int x = next.get(i);
            if(seen[x]) {
                return false;
            }
            seen[x] = true;
            if(graph.containsKey(x)) cycle = cycle && dfs(graph , seen , x , completed);
            seen[x] = false;
        }
        completed[num] = true;
        return cycle;
    }
}