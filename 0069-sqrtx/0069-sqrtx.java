class Solution {
    public int mySqrt(int x) {
        long min = 0;
        long max = x/2 + 1;
        while(min <= max){
            long mid = (max + min) / 2;
            if(mid * mid == x || ((mid + 1) * (mid + 1) > x && mid * mid < x)) return (int) mid;
            else if((mid - 1) * (mid - 1) < x && mid * mid > x) return (int) (mid - 1);
            else if( mid*mid > x ) max = mid - 1;
            else min = mid + 1;
        }
        return 0;
    }
}