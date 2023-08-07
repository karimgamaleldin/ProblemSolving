class Solution {
     public double myPow(double x, int n) {
        return myPowH(x, (long) n);
    }
    public double myPowH(double x, long n) {
        if(n == 0) return 1;
        double solution = 1;
        if(n < 0){
            n *= -1;
            x = 1 / x;
        }
        while(n != 0){
            if(n % 2 == 1){
                solution = solution * x;
                n--;
            }
            n /= 2;
            x = x * x;
        }
        return solution;
    }
    // public double helper(double x , int n){
    //     if(n == 0) return 1;
    //     if(n < 0) return 1.0 / helper(x , -1 * n);
    //     if(n % 2 == 1) return x * helper(x * x , (n - 1) / 2);
    //     return helper(x * x , n / 2);
    // }
}