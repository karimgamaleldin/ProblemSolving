class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length - 3 ; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){
                for(int j = i+1 ; j < nums.length - 2 ; j++){
                    if(j == i+1 || j > i+1 && nums[j] != nums[j-1]){
                        int left = j+1 ;
                        int right = nums.length - 1;
                        while(left < right){
                            long ctarget = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];
                            if(ctarget == ((long) target)){
                                ArrayList<Integer> curr = new ArrayList<Integer>();
                                curr.add(nums[i]);
                                curr.add(nums[j]);
                                curr.add(nums[left]);
                                curr.add(nums[right]);
                                result.add(curr);
                                left++;
                                right--;
                                while(left < right && nums[left] == nums[left-1]) left++;
                                while(right > left && nums[right] == nums[right+1]) right--; 
                            }else if( ctarget < ((long) target) ){
                                left++;
                            }else{
                                right--;
                            }
                        }
                    }
                }
            }
            
        }
        return result;
    }
    // public void helper(int k ,int[] nums , int target , int start , ArrayList<ArrayList<Integer>> result , ArrayList<Integer> curr){
    //     if(k == 2){
    //         int i = start;
    //         int j = nums.length - 1;
    //         int target = 0;
    //         for(int i = 0 ; i < curr.size() ; i++) target -= curr.get(i);
    //         while(i < j){
    //             if(nums[i] + nums[j] = target){
    //                 curr.add(nums[i]);
    //                 curr.add(nums[j]);
    //                 result.add(curr);
    //                 i++;
    //                 j--;
    //                 while(i < j && nums[i] = nums[i-1]) i++;
    //                 while(j > i && nums[i] = nums[j+1]) j--; 
    //             }else if( nums[i] + nums[j] < 0 ){
    //                 i++;
    //             }else{
    //                 j--;
    //             }
    //         }
    //     }
    //     else{
    //         for(int i = start ; i < nums.length - k + 1 ; i++){
    //             if(i == 0 || i > 0 && nums[i] != nums[i-1]){
    //                 curr.add(nums[i]);
    //                 helper(k - 1 , nums , target , i + 1 , result , curr);
    //             }
    //         }
    //     }
    // }
}