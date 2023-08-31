class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int[] ma: matrix){
            for(int n : ma){
                pq.add(n);
                if(pq.size() == k + 1) pq.poll();
            }
        }
        return pq.poll();
    }
}