class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = num.length - 1 ; i >= 0 ; i--){
            int t = carry + num[i] + k % 10;
            carry = t / 10;
            k = k / 10;
            t = t % 10;
            res.addFirst(t);
        }
        while(k != 0 || carry != 0){
            int t = carry + k % 10;
            carry = t / 10;
            k = k / 10;
            t = t % 10;
            res.addFirst(t);
        }
        return res;
    }
}