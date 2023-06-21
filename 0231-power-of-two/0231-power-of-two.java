class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0; // as if n is power of 2 then 1 bit and anding with the number less than it will ensure we have no other 1 bits
        
    }
}