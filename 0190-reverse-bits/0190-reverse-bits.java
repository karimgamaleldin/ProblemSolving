public class Solution {
    public int reverseBits(int n) {
        int x = 0;
        int mask = 1;
        for(int i = 0 ; i < 32 ; i++){
            x = (x << 1) + (n & mask);
            n >>= 1;
        }
        return x;
    }
}