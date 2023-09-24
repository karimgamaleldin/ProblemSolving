class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        while(l <= r){
            int mid = l + (r - l) / 2;
            long x = (long) mid * mid;
            if(x == num) return true;
            else if(x < num) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}