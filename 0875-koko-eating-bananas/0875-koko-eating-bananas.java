class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int i = 0 ; i < piles.length ; i++) right = Math.max(piles[i] , right);
        while(left <= right){
            int mid = left + (right - left) / 2;
            int x = 0;
            for(int i = 0 ; i < piles.length ; i++){
                x += Math.ceil((double) piles[i] / mid);
            }
            if(x > h) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}