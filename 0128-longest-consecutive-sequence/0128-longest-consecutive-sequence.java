class Solution {
    public int longestConsecutive(int[] nums) {
        // O(n) solution
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(!set.contains(nums[i] - 1)){
                int curr = 1;
                while(set.contains(nums[i] + curr)){
                    curr++;
                }
                max = Math.max(max , curr);
            }
        }
        return max;
        // O(nlogn) solution:
        // if(nums.length == 0) return 0; 
        // Arrays.sort(nums);
        // int max = 0;
        // int curr = 1;
        // for(int i = 0 ; i < nums.length - 1 ; i++){
        //     if(nums[i]+1 != nums[i+1] && nums[i] != nums[i+1]){
        //         max = Math.max(max , curr);
        //         curr = 1;
        //     }else if(nums[i] != nums[i+1]){
        //         curr++;
        //     }
        // }
        // max = Math.max(max , curr);
        // return max;
    }
}