class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r = new int[1 + nums.length - k];
        Deque<Integer> dq = new ArrayDeque<>(); // We will store the index here
        int i;
        for(i = 0 ; i < nums.length; i++){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]) dq.removeLast();
            dq.addLast(i);
            if(dq.getFirst() + k <= i) dq.removeFirst();
            if(i >= k - 1) r[i - k + 1] = nums[dq.getFirst()];
        }
        return r;
    }
}