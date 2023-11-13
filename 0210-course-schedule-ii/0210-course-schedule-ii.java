class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        HashMap<Integer, List<Integer>> adgLists = new HashMap<>();
        for(int i = 0; i < numCourses; i++) adgLists.put(i, new ArrayList<>());
        for(int[] pre : prerequisites){
            indeg[pre[0]]++;
            adgLists.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++) if(indeg[i] == 0) q.add(i);
        int i = 0;
        int[] sol = new int[numCourses];
        while(!q.isEmpty()){
            int x = q.remove();
            List<Integer> l = adgLists.get(x);
            for(int n : l){
                indeg[n]--;
                if(indeg[n] == 0){
                    q.add(n);
                }
            }
            sol[i++] = x;
        }
        return i == numCourses ? sol : new int[]{};
    }
}