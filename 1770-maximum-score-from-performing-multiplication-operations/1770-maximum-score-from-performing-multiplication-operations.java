class Solution {
    HashMap<String, Integer> map;
    int[] nums;
    int[] muls;
    public int maximumScore(int[] nums, int[] multipliers) {
        this.map = new HashMap<>();
        this.nums = nums;
        this.muls = multipliers;
        int k = dp(0, nums.length - 1, 0);
        return k;
    }
    
    public int dp(int i, int j, int len){
        if(i > j || len == muls.length) return 0;
        String s = getKey(i, j, len);
        if(map.containsKey(s)) return map.get(s);
        int start = nums[i] * muls[len] + dp(i + 1 , j , len + 1);
        int end = nums[j] * muls[len] + dp(i, j - 1, len + 1);
        map.put(s, Math.max(start, end));
        return Math.max(start, end);
    }
    public String getKey(int i, int j, int k){
        return "" + i + "," + j + "," + k;
    }
}