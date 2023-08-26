class Solution {
    static class Edge {
        int from;
        int to;
        int cost;
        
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] seen = new boolean[n + 1]; seen[k] = true;
        HashMap<Integer , List<Edge>> map = new HashMap<>();
        for(int i = 1 ; i <= n ; i++) map.put(i , new ArrayList<>());
        for(int[] t : times) map.get(t[0]).add(new Edge(t[0] , t[1] , t[2]));
        PriorityQueue<Edge> pq = new PriorityQueue<>((a , b) -> (a.cost - b.cost));
        for(int i = 0 ; i < map.get(k).size() ; i++) pq.add(map.get(k).get(i));
        int max = 0;
        int count = n;
        while(!pq.isEmpty() && count > 0){
            Edge e = pq.poll();
            if(!seen[e.to]){
                seen[e.to] = true;
                max = Math.max(e.cost , max);
                for(Edge x : map.get(e.to)){
                    x.cost += e.cost;
                    pq.add(x);
                }
                count--;
            }
        }
        for(int i = 1 ; i <= n ; i++) if(!seen[i]) return -1;
        return max;
    }
}
