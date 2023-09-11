class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        int[] ans = new int[n + 1];
        for(int i = n; i >= 1; i--){
            int x = digits[i - 1] + carry;
            ans[i] = x % 10;
            carry = x / 10;
        }
        ans[0] = carry;
        if(ans[0] != 0) return ans;
        return Arrays.copyOfRange(ans, 1, n + 1);
    }
}