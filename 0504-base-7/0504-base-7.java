class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        boolean n = num < 0;
        if(n) num *= -1;
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int t = num % 7;
            sb.insert(0 , t);
            num /= 7;
        }
        if(n) sb.insert(0 , '-');
        return sb.toString();
    }
}