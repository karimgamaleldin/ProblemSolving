class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int total = 0;
        for(int i = 0; i < weights.length ; i++) {
            total += weights[i];
            l = Math.max(l, weights[i]);
        }
        int r = total;
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int count = 0;
            int current = 0;
            for(int i = 0; i < weights.length ; i++){
                current += weights[i];
                if(current >= mid){
                    if(current == mid) current = 0;
                    else current = weights[i];
                    count++;
                }
            }
            if(current != 0) count++;
            if(count > days) l = mid + 1;
            else{
                // System.out.println(days + "-" + count + "-" + mid + "-" + ans);
                ans = mid;
                // System.out.println(days + "-" + count + "-" + mid + "-" + ans);
                r = mid - 1;
            }
        }
        return ans;
    }
}