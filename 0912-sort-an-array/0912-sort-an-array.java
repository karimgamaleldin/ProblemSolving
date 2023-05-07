class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums , 0 , nums.length-1);
        return nums;
    }
    public void merge(int[] A , int low , int mid , int end){
        int sizeSmall = mid - low + 1 ; //inclusive
        int sizeBig = end - mid; //execlusive
        int[] x = new int[sizeSmall];
        int[] y = new int[sizeBig];
        for(int i = 0 ; i < sizeSmall ; i++) x[i] = A[i+low];
        for(int j = 0 ; j < sizeBig ; j++) y[j] = A[j+ mid + 1];
        int i = 0;
        int j = 0;
        int k = low;
        while(i < sizeSmall && j < sizeBig){
            if(x[i] <= y[j]) A[k++] = x[i++];
            else A[k++] = y[j++];
        }
        for(;i<sizeSmall;i++) A[k++] = x[i];
        for(;j<sizeBig;j++) A[k++] = y[j];
    }
    public void mergeSort(int[] A , int l , int r){
        if(l < r){
            int mid = l + ( r - l ) / 2;
            mergeSort(A , l , mid);
            mergeSort(A , mid+1 , r);
            merge(A , l , mid , r);
        }
    }
}