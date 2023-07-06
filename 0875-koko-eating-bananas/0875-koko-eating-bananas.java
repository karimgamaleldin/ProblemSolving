class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        int r = 0;
        for(int i = 0 ; i < piles.length ; i++) right = Math.max(right , piles[i]);
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int i = 0; i < piles.length ; i++){
                count += Math.ceil((double)piles[i] / mid);
            }
            if(count <= h){
                r = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return r;
    }
}