class NumArray {
    int [] numArray;

    public NumArray(int[] nums) {
        this.numArray = nums;
        for(int i = 1 ; i < nums.length ; i++){
            numArray[i] += numArray[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return left == 0 ? numArray[right] : numArray[right] - numArray[left - 1] ;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */