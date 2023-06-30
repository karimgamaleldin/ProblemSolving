class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        int right = 0;
        for(;right < k ; right++){
            sum += arr[right];
        }
        if((sum / k) >= threshold) count++;
        for(; right < arr.length ; right++){
            sum += arr[right] - arr[right - k];
            if(sum >= threshold * k) count++;
        }
        return count;
        
    }
}