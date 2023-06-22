class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int memo1 = 1;
        int memo2 = 1;
        for(int i = n - 2; i >= 0 ;i--){
            int temp = memo1;
            memo1 = memo1 + memo2;
            memo2 = temp;
        }
        return memo1;
    }
}