class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for(int i = 0 ; i < pairs.size() ; i++){
            uf.union(pairs.get(i).get(0) , pairs.get(i).get(1));
        }
        String res = uf.findLex(s);
        return res;
        
    }
    static class UnionFind{
        int[] root;
        int[] rank;
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n];
            for(int i = 0 ; i < n ; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x){
            if(x == -1 || root[x] == x) return x;
            return root[x] = find(root[x]);
        }
        public void union(int x , int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]) root[rootY] = rootX;
                else if(rank[rootY] > rank[rootX]) root[rootX] = rootY;
                else{
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
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