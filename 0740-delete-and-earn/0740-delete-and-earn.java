class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max= Math.max(max, nums[i]);
            min= Math.min(min, nums[i]);
        }
        int two = map.getOrDefault(min, 0) * min;
        int one = Math.max(map.getOrDefault(min + 1, 0) * (min + 1), two);
        for(int i = min + 2 ; i <= max; i++){
            // System.out.println(one + "," + two);
            int temp = one;
            one = Math.max(one, two + map.getOrDefault(i, 0) * i);
            two = temp;
            // System.out.println(one + "," + two);
        }
        return Math.max(one, two);
    }
}