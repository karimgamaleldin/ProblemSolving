class Solution {
    public int getSum(int a, int b) {
        while(a != 0){
            int t = b;
            b = b ^ a;
            a = (t & a) << 1;
        }
        return b;
    }
}