class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] in = new boolean[n];
        for(int i = 0 ; i < edges.size() ; i++){
            in[edges.get(i).get(1)] = true;
        }
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++){
            if(!in[i]) arr.add(i);
        }
        return arr;
    }
}