class Solution {
    HashMap<String , Integer> memo = new HashMap<>();
    int[] nums;
    int[] multipliers;
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        return dp(0 , n - 1 , 0);
    }
    public int dp(int i , int j , int m){
        if(i > j || m == multipliers.length) return 0;
        else if(memo.containsKey(keyMap(i , j , m))) return memo.get(keyMap(i , j , m));
        int start = nums[i] * multipliers[m] + dp(i + 1 , j , m + 1);
        int end   = nums[j] * multipliers[m] + dp(i , j - 1 , m + 1);
        int x = Math.max(start , end);
        memo.put(keyMap(i , j , m) , x);
        return x;
    }
    public String keyMap(int i , int j , int m){
        return "" + i + " " + j + " " + m;
    }
}