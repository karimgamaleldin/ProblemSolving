class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0 ; i < n ; i++){
            int[] arr = isConnected[i];
            for(int j = 0 ; j < n ; j++){
                if(i != j && arr[j] == 1)uf.union(i , j);
            }
        }
        return uf.numberOfComponents();
    }
    static class UnionFind{
        private int[] root;
        
        public UnionFind(int size){
            root = new int[size];
            for(int i = 0 ; i < size ; i++) root[i] = i;
        }
        
        public int find(int x){ 
            while(x != root[x]) x = root[x];
            return x;
        }
        
        public void union(int x , int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) root[rootY] = rootX;
        }
        
        public boolean connected(int x , int y){return find(x) == find(y);}
        
        public int numberOfComponents(){
            HashSet<Integer> s = new HashSet<>();
            for(int i = 0 ; i < root.length ; i++) s.add(find(root[i]));
            return s.size();
        }
    }
}