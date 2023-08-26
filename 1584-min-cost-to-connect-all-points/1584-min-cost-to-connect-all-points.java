class Solution {
    static class Edge{
        int from;
        int to;
        int cost;
        public Edge(int i , int j , int k){
            from = i;
            to = j;
            cost = k;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int size = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        boolean[] visited = new boolean[size];
        int result = 0;
        int count = size - 1;
        // Add all edges from points[0] vertexs
        int[] coordinate1 = points[0];
        for (int j = 1; j < size; j++) {
            // Calculate the distance between two coordinates.
            int[] coordinate2 = points[j];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) + 
                       Math.abs(coordinate1[1] - coordinate2[1]);
            Edge edge = new Edge(0, j, cost);
            pq.add(edge);
        }
        visited[0] = true;

        while (!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            int point1 = edge.from;
            int point2 = edge.to;
            int cost = edge.cost;
            if (!visited[point2]) {
                result += cost;
                visited[point2] = true;
                for (int j = 0; j < size; j++) {
                    if (!visited[j]) {
                        int distance = Math.abs(points[point2][0] - points[j][0]) + 
                                       Math.abs(points[point2][1] - points[j][1]);
                        pq.add(new Edge(point2, j, distance));
                    }
                }
                count--;
            }
        }
        return result;
    }
}
//         int n = points.length;
//         List<List<Integer>> edges = new ArrayList<>();
//         for(int i = 0 ; i < n ; i++){
//             for(int j = i + 1 ; j < n ; j++){
//                 List<Integer> temp = new ArrayList<>();
//                 temp.add(i);
//                 temp.add(j);
//                 temp.add(manhattan(points[i] , points[j]));
//                 edges.add(temp);
//             }
//         }
//         Collections.sort(edges , (a , b) -> {
//            return a.get(2) - b.get(2); 
//         });
//         UnionFindOptimized uf = new UnionFindOptimized(n);
//         int counter = 0;
//         for(List<Integer> e : edges){
//             uf.union(e.get(0) , e.get(1) , e.get(2));
//             if(uf.getCount() == 1) break;
//             counter++;
//         }
//         return uf.cost;
//     }
//     public int manhattan(int[] x , int[] y){
//         return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
//     }
//         static class UnionFindOptimized{
//         private int[] root;
//         private int[] rank;
//         private int count;
//              int cost;
//         public UnionFindOptimized(int size){ // Initialize the root and rank array
//             this.root = new int[size];
//             this.rank = new int[size];
//             this.count = size;
//             this.cost = 0;
//             for(int i = 0 ; i < size ; i++){
//                 this.root[i] = i;
//                 this.rank[i] = 1;
//             }
//         }

//         public int find(int x){
//             if(root[x] == x) return x;
//             return root[x] = find(root[x]);
//         }

//         public void union(int x , int y , int c) {
//             int rootX = find(x);
//             int rootY = find(y);
//             if(rootX != rootY) {
//                 if (rank[rootX] < rank[rootY]) root[rootX] = rootY;
//                 else if (rank[rootX] > rank[rootY]) root[rootY] = rootX;
//                 else {
//                     root[rootY] = rootX;
//                     rank[rootX]++;
//                 }
//                 count--;
//                 cost += c;
//             }
//         }

//         public boolean isConnected(int x , int y){
//             return find(x) == find(y);
//         }
//         public int getCount(){
//             return count;
//         }
//     }
// }