class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majCand = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(count == 0) majCand = nums[i];
            count = majCand == nums[i] ? count + 1 : count - 1;
        }
        return majCand;
    }
}