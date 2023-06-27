class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> r = new LinkedList<List<Integer>>();
        for(int i = 0 ; i < nums.length - 2 ; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int x = nums[i] + nums[j] + nums[k];
                if(x == 0){
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[k]);
                    r.add(t);
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(k > j && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }
                else if( x < 0 ) j++;
                else k--;
            }
            while(i < nums.length - 2 && nums[i] == nums[i+1]) i++;
        }
        return r;
    }
}