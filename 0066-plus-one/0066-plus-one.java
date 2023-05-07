class Solution {
    public int[] plusOne(int[] digits) {
        int x = 1;
        for(int i = digits.length-1 ; i >= 0 && x > 0; i--){
            int y = (digits[i] + 1) > 9 ? 0 : (digits[i] + 1) ;
            x = (y == 0)? 1 : 0;
            digits[i] = y;
        }
        if(x == 0) return digits;
        int[] temp =  new int[digits.length + 1];
            temp[0] = 1;
            for(int i = 1 ; i <= digits.length ; i++){
                temp[i] = digits[i-1];
            }
        return temp;
    }
}