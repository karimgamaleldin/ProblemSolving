class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            double x = eucledianDistanceToOrigin(a);
            double y = eucledianDistanceToOrigin(b);
            if(x > y) return -1;
            else if(x < y) return 1;
            return 0;   
        });
        
        for(int[] p: points){
            pq.add(p);
            if(pq.size() > k) pq.poll();
        }
        int[][] sol = new int[k][2];
        for(int i = k - 1; i >= 0; i--) sol[i] = pq.poll();
        return sol;
    }
    
    private double eucledianDistanceToOrigin(int[] point1){
        return Math.sqrt(Math.pow(point1[0], 2) + Math.pow(point1[1], 2));
    }
}