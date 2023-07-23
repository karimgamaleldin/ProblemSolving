class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];
        for(int i = 0 ; i < nums.length ; i++){
            bucket[nums[i]]++;
        }
        int x = 0;
        for(int i = 0 ; i < 3 ; i++){
            int j = x;
            for (; x < bucket[i] + j ; x++) nums[x] = i;
        }
    }
}