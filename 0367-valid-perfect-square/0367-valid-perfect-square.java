class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        long l = 1;
        long r = num / 2;
        while(l <= r){
            long mid = l + (r - l) / 2;
            long x = mid * mid;
            if(x == num){
                return true;
            }else if(x > num){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}