class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int i = 0 ; 
        int j = nums.length - 1;
        int k = 0;
        int[] r = new int[nums.length];
        while(i <= j){
            r[k++] = nums[j--];
            if(i < j) r[k++] = nums[i++];
        }
        
        return r;
    }
}