class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        int i = 0;
        Arrays.sort(potions);
        for(int s: spells){
            int l = 0;
            int r = potions.length - 1;
            int v = -1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                long x = (long) potions[mid] * s;
                if(x >= success){
                    v = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
                // System.out.println(s + "-" + x + "-" + mid);
            }
            if(v == -1){
                i++;
                continue;
            }
            ans[i++] = potions.length - v;
        }
        return ans;
    }
}