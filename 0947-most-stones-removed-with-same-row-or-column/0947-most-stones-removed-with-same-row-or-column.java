class Solution {
    public int removeStones(int[][] stones) {
        int m = stones.length;
        UnionFind uf = new UnionFind(m);
        for(int i = 0 ; i < m ; i++){
            int[] x = stones[i];
            for(int j = i + 1 ; j < m ; j++){
                int[] y = stones[j];
                // System.out.println('h');
                if(x[0] == y[0] || x[1] == y[1]) uf.union(i, j);
            }
        }
        return m - uf.getCount();
    }
    static class UnionFind{
        int[] rank;
        int[] uf;
        int count;
        public UnionFind(int n){
            this.rank = new int[n];
            this.count = n;
            this.uf = new int[n];
            for(int i = 0 ; i < n ; i++){
                rank[i] = 1;
                uf[i] = i;
            }
        }
        
        public int find(int x){
            if(x == uf[x]) return x;
            return uf[x] = find(uf[x]);
        }
        
        public void union(int r1, int r2){
            int f1 = find(r1);
            int f2 = find(r2);
            if(f1 != f2){
                // System.out.println('d');
                if(rank[f1] < rank[f2]) uf[f1] = uf[f2];
                else if(rank[f1] > rank[f2]) uf[f2] = uf[f1];
                else{
                    uf[f1] = uf[f2];
                    rank[f1]++;
                }
                count--;
            }
        }
        public int getCount(){
            return count;
        }
    }
}