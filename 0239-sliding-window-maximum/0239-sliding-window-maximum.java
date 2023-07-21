class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] r = new int[nums.length - k + 1];
        for(int i = 0 ; i < nums.length ; i++){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]) dq.removeLast();
            dq.addLast(i);
            if(dq.getFirst() < i - k + 1) dq.removeFirst();
            if(i >= k - 1) r[i - k + 1] = nums[dq.getFirst()];
        }
        return r;
    }
}