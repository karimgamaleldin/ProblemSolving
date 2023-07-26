class Solution {
    // we can sort here as it doesnot matter the order
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i++) nums[i] += nums[i - 1];
        int[] arr = new int[m];
        for(int i = 0 ; i < m ; i++){
            int target = queries[i];
            int left = 0;
            int right = n - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] <= target){
                    left = mid + 1;
                    if(nums[mid] == target) break;
                }else{
                    right = right - 1;
                }
            }
            arr[i] = left;
        }
        return arr;
    }
}