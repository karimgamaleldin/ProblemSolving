class Solution {
    public void duplicateZeros(int[] arr) {
        int dups = 0;
        int len = arr.length - 1;
        for(int i = 0 ; i <= len - dups ; i++){
            if(arr[i] == 0){
                if(i == len - dups){
                    arr[len] = 0;
                    len -= 1;
                    break;
                }
                dups++;
            }
        }
        int last = len - dups;
        for(int i = last ; i >= 0 ; i--){
            if(arr[i] == 0){
                arr[i + dups] = 0;
                dups--;
                arr[i + dups] = 0;
            }else{
                arr[i + dups] = arr[i];
            }
        }
    }
}