class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : nums){
            pq.add(num);
        }
        while(k-- != 1) pq.remove();
        return pq.peek();
    }
}