class Solution {
    HashMap<Integer , List<Integer>> rMap = new HashMap<>();
    HashMap<Integer , List<Integer>> bMap = new HashMap<>();
    int rm;
    int bm;
    int[] ans;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ans = new int[n];
        rm = redEdges.length;
        bm = blueEdges.length;
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0] = 0;
        for(int i = 0 ; i < n ; i++){
            rMap.put(i , new ArrayList<Integer>());
            bMap.put(i , new ArrayList<Integer>());
        }
        for(int i = 0 ; i < redEdges.length ; i++) rMap.get(redEdges[i][0]).add(i);
        for(int i = 0 ; i < blueEdges.length ; i++) bMap.get(blueEdges[i][0]).add(i);
        bfs(true , redEdges , blueEdges);
        bfs(false , redEdges , blueEdges);
        for(int i = 0 ; i < ans.length ; i++){
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        return ans;
    }
    
    public void bfs(boolean red , int[][] redEdges, int[][] blueEdges){
        Queue<Integer> q = new LinkedList<>();
        boolean[] re = new boolean[rm];
        boolean[] be = new boolean[bm];
        q.add(0);
        int steps = 0;
        while(!q.isEmpty()){
            steps++;
            int s = q.size();
            for(int i = 0 ; i < s ; i++){
                int t = q.remove();
                List<Integer> temp = red ? rMap.get(t) : bMap.get(t);
                for(int j = 0 ; j < temp.size() ; j++){
                    int edgeI = temp.get(j);
                    int[] arr = red ? redEdges[edgeI] : blueEdges[edgeI];
                    boolean f = red ? re[edgeI] : be[edgeI];
                    if(!f){
                        if(red) re[edgeI] = true;
                        else be[edgeI] = true;
                        q.add(arr[1]);
                        ans[arr[1]] = Math.min(ans[arr[1]] , steps);
                    }
                }
            }
            red = !red;
        }
    }
}