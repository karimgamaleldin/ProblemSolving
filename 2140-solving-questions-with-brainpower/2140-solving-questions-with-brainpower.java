class Solution {
    public long mostPoints(int[][] questions) {
        long tab[] = new long[questions.length];
        tab[questions.length - 1] = questions[questions.length - 1][0];
        for(int i = questions.length - 2 ; i >= 0 ; i--){
            int j = i + questions[i][1] + 1;
            long x = j < questions.length ? tab[j] : 0L;
            tab[i] = Math.max(questions[i][0] + x , tab[i + 1]);
        }
        return tab[0];
    }
    // Map<Integer , Long> memo = new HashMap<>();
    // public long mostPoints(int[][] questions) {
    //     return dp(0 , questions);
    // }
    // public long dp(int i , int[][] arr){
    //     if(i >= arr.length) return 0;
    //     if(memo.containsKey(i)){
    //         return memo.get(i);
    //     }
    //     int j = i + arr[i][1] + 1;
    //     memo.put(i, Math.max(arr[i][0] + dp(j, arr), dp(i + 1, arr)));
    //     return memo.get(i);
    // }
}