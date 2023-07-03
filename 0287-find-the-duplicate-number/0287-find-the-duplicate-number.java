class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);
        int slow2wy = 0;
        do{
            slow = nums[slow];
            slow2wy = nums[slow2wy];
        }while(slow != slow2wy);
        return slow2wy;
    }
}