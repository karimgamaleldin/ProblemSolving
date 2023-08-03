class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 8 ; i++){
            int mask = 15;
            int t = mask & num;
            if(num != 0) sb.insert(0 , hex(t));
            else break;
            num = num >> 4;
        }
        return sb.toString();
    }
    public char hex(int x){
        if(x < 10) return ("" + x).charAt(0);
        int c = (x - 10) + 'a';
        return (char) c;
    }
}