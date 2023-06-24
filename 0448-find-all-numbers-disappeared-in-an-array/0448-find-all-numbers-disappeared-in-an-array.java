class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] arr = new boolean[nums.length + 1];
        List<Integer> r = new ArrayList<>();
        for(int i = 0 ; i < nums.length;i++) arr[nums[i]] = true;
        for(int i = 1 ; i < nums.length + 1;i++) if(arr[i] == false) r.add(i);
        return r;
    }
}