class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        Map<Integer , List<Integer>> map = new HashMap<>();
        int[] ans = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++) map.put(i , new ArrayList<>());
        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];
            indeg[a]++;
            map.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++) if(indeg[i] == 0) q.add(i);
        int i = 0;
        HashSet<Integer> seen = new HashSet<>();
        while(!q.isEmpty()){
            int pre = q.remove();
            seen.add(pre);
            List<Integer> temp = map.get(pre);
            for(int next : temp){
                indeg[next]--;
                if(indeg[next] == 0 && !seen.contains(next)) q.add(next);
            }
            ans[i++] = pre;
        }
        return i != numCourses ? new int[0] : ans;
    }
}