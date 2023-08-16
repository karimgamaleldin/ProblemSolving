class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int one = 0;
        int two = 1;
        int three = 1;
        for(int i = 3 ; i <= n ; i++){
            int temp = three;
            three = one + two + three;
            one = two;
            two = temp;
        }
        return three;
    }
}