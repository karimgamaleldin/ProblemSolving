class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < numCourses; i++) map.put(i, new ArrayList<>());
        for(int[] p: prerequisites){
            indeg[p[0]]++;
            map.get(p[1]).add(p[0]);
        }
        List<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cour = q.remove();
            arr.add(cour);
            List<Integer> li = map.get(cour);
            for(int x: li){
                indeg[x]--;
                if(indeg[x] == 0) q.add(x);
            }
        }
        if(arr.size() != numCourses) return new int[0];
        int[] ans = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}