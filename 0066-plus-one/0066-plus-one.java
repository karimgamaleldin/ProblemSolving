class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int num = digits[i];
            digits[i] = (num + c) % 10;
            c = (num + c) / 10;
        }
        if(c != 0){
            int[] ans = new int[digits.length + 1];
            ans[0] = c;
            for(int i = 1; i < digits.length + 1; i++) ans[i] = digits[0];
            return ans;
        }
        return digits;
    }
}