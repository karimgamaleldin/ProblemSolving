/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            boolean f = isBadVersion(mid);
            if(!f && isBadVersion(mid + 1)){
                return mid + 1;
            }
            if(!f){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}