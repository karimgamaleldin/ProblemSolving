class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> p : pairs){
            uf.union(p.get(0), p.get(1));
        }
        return uf.findLex(s);
        
    }
    
    static class UnionFind{
        int[] rank;
        int[] root;
        int count;
        
        public UnionFind(int n){
            this.rank = new int[n];
            this.root = new int[n];
            for(int i = 0 ; i < n; i++){
                this.root[i] = i;
                this.rank[i] = i;
            }
            this.count = n;
        }
        
        public int find(int x){
            if(root[x] == x) return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;
            if(rank[rootX] < rank[rootY]) root[rootX] = rootY;
            else if(rank[rootY] < rank[rootX]) root[rootY] = rootX;
            else{
                root[rootX] = rootY;
                rank[rootY] += 1;
            }
            count--;
        }
        public String findLex(String w){
            HashMap<Integer , PriorityQueue<Character>> map = new HashMap<>();
            for(int i = 0 ; i < w.length() ; i++){
                int root = find(i);
                if(!map.containsKey(root)) map.put(root , new PriorityQueue<>());
                map.get(root).add(w.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < w.length() ; i++){
                int root = find(i);
                sb.append(map.get(root).poll());
            }
            return sb.toString();
        }
    }
}