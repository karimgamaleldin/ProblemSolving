class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination){
        UnionFindOptimized uf = new UnionFindOptimized(n);
        for(int[] e : edges){
            uf.union(e[0] , e[1]);
        }
        return uf.isConnected(source , destination);
    }
static class UnionFindOptimized{
        private int[] root;
        private int[] rank;
        private int count;
        public UnionFindOptimized(int size){ // Initialize the root and rank array
            this.root = new int[size];
            this.rank = new int[size];
            this.count = size;
            for(int i = 0 ; i < size ; i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int x){
            if(root[x] == x) return x;
            return root[x] = find(root[x]);
        }

        public void union(int x , int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                if (rank[rootX] < rank[rootY]) root[rootX] = rootY;
                else if (rank[rootX] > rank[rootY]) root[rootY] = rootX;
                else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }
    public boolean isConnected(int x , int y){
        return find(x) == find(y);
    }
}
}
//         HashMap<Integer , List<Integer>> map = new HashMap<>();
//         for(int[] edge : edges){
//             if(!map.containsKey(edge[0])) map.put(edge[0] , new ArrayList<>());
//             map.get(edge[0]).add(edge[1]);
//             if(!map.containsKey(edge[1])) map.put(edge[1] , new ArrayList<>());
//             map.get(edge[1]).add(edge[0]);
//         }
//         return dfs(map , source , destination , new HashSet<>());
//     }
    
//     public boolean dfs(HashMap<Integer , List<Integer>> map , int source , int destination , HashSet<Integer> seen){
//         if(source == destination) return true;
//         boolean f = false;
//         List<Integer> m = map.get(source);
//         for(Integer i : m){
//             if(f) break;
//             if(!seen.contains(i)){
//                 seen.add(i);
//                 f = dfs(map , i , destination , seen);
//             }
//         }
//         return f;
//     }
