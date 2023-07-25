class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> r = new LinkedList<>();
        for(int i = 1 ; i <= 9 ; i++)
            backtrack(r , i , n - 1 , k);
        int[] arr = new int[r.size()];
        for(int i = 0 ; i < r.size() ; i++) arr[i] = r.get(i);
        return arr;
    }
    public void backtrack(List<Integer> r , int currNum , int n , int k){
        if(n == 0){
            r.add(currNum);
            return;
        }
        int num = currNum % 10;
        for(int i = 0 ; i <= 9 ; i++){
            int a = i < num ? num - i : i - num;
            if(a == k){
                int b = i + currNum * 10;
                backtrack(r , b , n - 1 , k);
            }
        }
    }
}