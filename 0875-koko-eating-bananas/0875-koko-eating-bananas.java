class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int i = 0 ; i < piles.length; i++) r = Math.max(r, piles[i]);
        int ans = r;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int count = 0;
            for(int i = 0; i < piles.length; i++){
                count += Math.ceil((double) piles[i] / mid);
            }
            if(count <= h){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}