class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int left = 1;
        int right = x / 2;
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long r = (long)mid * mid;
            if(r == x) return (int) mid;
            else if(r > x) right = mid - 1;
            else {
                res = (int) mid;
                left = mid + 1;
            }
        }
        return res;
    }
}