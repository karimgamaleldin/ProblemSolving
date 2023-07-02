class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        long min = 1;
        long max = num / 2;
        while(min <= max){
            long mid = (max + min) / 2;
            if(mid*mid == num) return true;
            else if(mid*mid < num) min = mid + 1;
            else max = mid - 1;
        }
        return false;
        
    }
}