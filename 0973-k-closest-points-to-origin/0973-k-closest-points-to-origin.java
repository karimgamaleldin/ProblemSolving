class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            double x = euc(a); double y = euc(b);
            if(x < y) return 1;
            return -1;
        });
        for(int[] point : points){
            pq.add(point);
            if(pq.size() > k) pq.remove();
        }
        int[][] ans = new int[k][];
        for(int i = 0 ; i < k ; i++){
            ans[i] = pq.remove();
        }
        return ans;
    }
    public double euc(int[] x){
        return  Math.sqrt(Math.pow(x[0], 2) + Math.pow(x[1], 2));
    }
}