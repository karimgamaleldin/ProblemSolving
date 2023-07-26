class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            int search = (int) Math.ceil(((double) success)/ spells[i]);
            int left = 0;
            int right = m - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(potions[mid] < search) left = mid + 1;
                else right = mid - 1;
            }
            arr[i] = m - left ;
        }
        return arr;
    }
}