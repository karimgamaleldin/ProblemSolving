class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // this is a sliding window problem but unordered so we need helper data structures
        Deque<Integer> inc = new ArrayDeque<>();
        Deque<Integer> dec = new ArrayDeque<>();
        int left = 0;
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            while(!inc.isEmpty() && nums[inc.getLast()] > nums[i]) inc.removeLast();
            while(!dec.isEmpty() && nums[dec.getLast()] < nums[i]) dec.removeLast();
            inc.addLast(i);
            dec.addLast(i);
            while(nums[dec.getFirst()] - nums[inc.getFirst()] > limit){
                if(left == dec.getFirst()) dec.removeFirst();
                if(left == inc.getFirst()) inc.removeFirst();
                left++;
            }
            max = Math.max(max , i - left + 1);
        }
        return max;
    }
}