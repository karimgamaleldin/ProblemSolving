class Solution {
    public int countGoodNumbers(long n) {
        long a = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int mod = 1000000007;
        long b = n / 2;
        long x = binexp(5L, a, mod) % mod;
        long y = binexp(4L, b, mod) % mod;
        return (int) (x * y % mod);
        
    }
    
    public long binexp(long x , long y, int mod){
        long res = 1;
        while(y > 0){
            if((y & 1) == 1) res = res * x % mod;
            x = x * x % mod;
            y >>= 1;
        }
        return (res % mod);
    }
}