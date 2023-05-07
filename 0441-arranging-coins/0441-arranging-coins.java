class Solution {
    public int arrangeCoins(int n) {
        long start = 1;
        long end = n;
        long r = 0;
        while(start <= end){
            long mid = start + (end - start)/2;
            long x = mid * (mid+1) / 2;
            if( x == n ) return (int)mid;
            if(x < n){
                r = Math.max(mid , r);
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return (int)r;
    }
    
}