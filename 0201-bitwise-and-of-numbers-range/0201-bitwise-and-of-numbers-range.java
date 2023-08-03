class Solution {
    // the question can be decoded to the longest binary prefix
    public int rangeBitwiseAnd(int left, int right) {
        int i = 0;
        while(left != right){
            left = left >> 1;
            right = right >> 1;
            i++;
        }
        left = left << i;
        return left;
    }
}