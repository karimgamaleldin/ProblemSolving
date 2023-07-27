class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length ;
        int max = trips[0][2];
        for(int i = 0 ; i < n ; i++) max = Math.max(max , trips[i][2]);
        int[] arr = new int[max + 1];
        for(int i = 0 ; i < n ; i++){
            int[] temp = trips[i];
            arr[temp[1]] += temp[0];
            arr[temp[2]] -= temp[0];
        }
        if(arr[0] > capacity) return false;
        for(int i = 1 ; i <= max ; i++){
            arr[i] += arr[i-1];
            if(arr[i] > capacity) return false;
        }
        return true;
    }
}