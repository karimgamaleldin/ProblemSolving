class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] count = new int[m];
        for(int i = 0 ; i < m ; i++){
            int c = 0;
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 1) c++;
            }
            count[i] = c;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int x = count[a];
            int y = count[b];
            if(x == y) return b - a;
            return y - x;
        });
        for(int i = 0 ; i < m; i++){
            pq.add(i);
            if(pq.size() == k + 1) pq.poll();
        }
        int[] ans = new int[k];
        for(int i = k - 1 ; i >= 0; i--) ans[i] = pq.poll();  
        return ans;
    }
}