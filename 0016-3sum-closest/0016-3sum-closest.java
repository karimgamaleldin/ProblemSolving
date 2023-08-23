class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int clo = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int temp = nums[j] + nums[k] + nums[i];
                int x = Math.abs(target - temp);
                if(diff > x){
                    diff = x;
                    clo = temp;
                }
                if(temp > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return clo;
    }
}