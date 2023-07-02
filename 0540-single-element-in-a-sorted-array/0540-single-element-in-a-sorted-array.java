class Solution {
    public int singleNonDuplicate(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while(min < max){
            int mid = (max + min) / 2;
            if(mid % 2 == 1){ // as we are always using the even index as its duplicate will be on the side
                mid--;
            }
            if( nums[mid] == nums[mid + 1]){ // comparing the even index with it's odd, if == then the subarray from min to max is ok
                min = mid + 2; // as we made a --
            } else{ // otherwise we will find the number on the left as the sequence will be broken
                max = mid; // as we already made a --
            }
        }
        return nums[min];
        
    }
}