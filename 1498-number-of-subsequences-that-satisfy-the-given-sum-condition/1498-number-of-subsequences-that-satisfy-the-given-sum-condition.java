class Solution {
    public int numSubseq(int[] nums, int target) {
               Arrays.sort(nums);
        int mod = (int) Math.pow(10, 9) + 7;
        int result = 0;
        int i = 0;
        int j = nums.length - 1;
        int[] powTwo = new int[nums.length]; 
        
        powTwo[0] = 1;
        for (int k = 1; k < nums.length; k++) {
            powTwo[k] = (powTwo[k - 1] * 2) % mod;
        }
        
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                int exponent = j - i;
                result = (result + powTwo[exponent]) % mod;
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}