class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFindOptimized uf = new UnionFindOptimized(n);
        for(int i = 0 ; i < n ; i++){
            int[] arr = isConnected[i];
            for(int j = 0 ; j < n ; j++){
                if(i != j && arr[j] == 1)uf.union(i , j);
            }
        }
        return uf.numberOfComponents();
    }
    static class UnionFindOptimized{
        private int[] root;
        private int[] rank;
        public UnionFindOptimized(int size){ // Initialize the root and rank array
            this.root = new int[size];
            this.rank = new int[size];
            for(int i = 0 ; i < size ; i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int x){
            if(root[x] == x) return x;
            return root[x] = find(root[x]);
        }

        public void union(int x , int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rank[rootX] < rank[rootY]) root[rootX] = rootY;
            else if(rank[rootX] > rank[rootY]) root[rootY] = rootX;
            else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
        
        public boolean connected(int x , int y){return find(x) == find(y);}
        
        public int numberOfComponents(){
            HashSet<Integer> s = new HashSet<>();
            for(int i = 0 ; i < root.length ; i++) s.add(find(root[i]));
            return s.size();
        }
    }
}