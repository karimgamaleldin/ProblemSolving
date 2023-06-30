class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int currSize = 0;
        int sum = 0;
        boolean found = false;
        int left = 0;
        for(int i = 0 ; i < nums.length ; i++){
            currSize++;
            sum += nums[i];
            if(sum >= target){
                found = true;
                while(left <= i && sum >= target){
                    size = Math.min(currSize , size);
                    currSize--;
                    sum -= nums[left++];
                }
            }
        }
        return found ? size : 0;
    }
}