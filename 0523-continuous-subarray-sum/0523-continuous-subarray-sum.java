class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> present = new HashMap<>();
        present.put(0,-1);
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            if(!present.containsKey(sum % k)){
                present.put(sum % k , i);
            }else if(i - present.get(sum % k) >= 2){ // as if a value is multiple of k then we should skip     
                return true;
            }
        }
        return false;
    }
}