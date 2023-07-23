class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int sum = 0;
        for(int p : piles){ 
            sum += p;
            pq.add(p);
        }
        int i = k;
        while(i-- != 0){
            int a = pq.remove();
            int b = a / 2;
            sum -= b;
            a -= b; 
            pq.add(a);
        }
        return sum;
    }
}