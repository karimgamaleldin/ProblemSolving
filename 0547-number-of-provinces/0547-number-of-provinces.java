class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        int j = 0;
        for(int[] arr: isConnected){
            for(int i = 0 ; i < arr.length; i++){
                if(arr[i] == 1) uf.union(i, j);
            }
            
            j++;
        }
        return uf.count;
    }
    
    static class UnionFind{
        int[] root;
        int[] rank;
        int count;
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
            count  = n;
        }
        
        public int find(int x){
            if(x == root[x]) return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x , int y){
            int a = find(x);
            int b = find(y);
            if(a == b) return;
            if(rank[a] > rank[b]) root[b] = a;
            else if(rank[a] < rank[b]) root[a] = b;
            else{
                root[b] = a;
                rank[b] = 1;
            }
            count--;
        }
        
        
    }
}