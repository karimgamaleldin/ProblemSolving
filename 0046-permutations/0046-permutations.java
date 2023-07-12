class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new LinkedList<>();
        helper(nums, new LinkedList<>() , r);
        return r;
    }
    public void helper(int[] nums , List<Integer> current , List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new LinkedList<>(current));
            return;
        }
        for(int num : nums){
            if(!current.contains(num)){
                current.add(num);
                helper(nums , current , result);
                current.remove(current.size() - 1);
            }
        }
    }
}