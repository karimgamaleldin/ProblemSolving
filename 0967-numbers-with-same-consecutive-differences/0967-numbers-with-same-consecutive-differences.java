class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> r = new LinkedList<>();
        backtrack(r , 1 , 0 , n , k , true);
        int[] arr = new int[r.size()];
        for(int i = 0 ; i < r.size() ; i++) arr[i] = r.get(i);
        return arr;
    }
    public void backtrack(List<Integer> r , int start , int currNum , int n , int k , boolean first){
        if(n == 0){
            r.add(currNum);
            return;
        }
        int num = currNum % 10;
        for(int i = start ; i <= 9 ; i++){
            int a = i < num ? num - i : i - num;
            if(first || a == k){
                int b = i + currNum * 10;
                backtrack(r , 0 , b , n - 1 , k , false);
            }
        }
    }
}