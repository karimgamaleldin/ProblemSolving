class Solution {
    public int minimumDifference(int[] nums, int k) {
        if( k == 1 ) return 0;
        Arrays.sort(nums);
        int min = nums[k-1] - nums[0];
        for(int i = 1; i < nums.length - k + 1 ; i++){
            min = Math.min(min , nums[k+i-1] - nums[i]);
        }
        return min;
    }
    public void printArray(int[] arr){
        for(int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + ",");
    }
}