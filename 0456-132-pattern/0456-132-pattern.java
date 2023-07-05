class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> mins = new Stack<Integer>();
        int min = nums[0];
        for(int i = 0 ; i < nums.length; i++){
            while(!s.isEmpty() && nums[i] >= s.peek()) {
                s.pop();
                mins.pop();
            }
            if(!s.isEmpty() && nums[i] > mins.peek()) return true;
            s.push(nums[i]);
            mins.push(min);
            min = Math.min(nums[i] , min);
        }
        return false;
        
    }
}