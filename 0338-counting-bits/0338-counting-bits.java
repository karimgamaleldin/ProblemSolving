class Solution {
    public int[] countBits(int n) {
        int[] x = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            x[i] = helper(i);
        }
        return x;
    }
    public int helper(int n){
        int count = (n & 0x00000001);
        while(n != 0){
            n = n >> 1;
            int y = (n & 0x00000001);
            count += y;
        }
        return count;
    }
}