class Solution {
    public int addDigits(int num) {
        while (num / 10 != 0) num = sum(num);
        return num;
    }
    public int sum(int num){
        int x = 0;
        while(num > 0){
            x += num % 10;
            num = num / 10;
        }
        return x;
    }
}