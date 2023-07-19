class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new LinkedList<>();
        helper(nums, new LinkedList<>() , r);
        return r;
    }
    public void helper(int[] nums , List<Integer> curr , List<List<Integer>> result){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                helper(nums , curr , result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}