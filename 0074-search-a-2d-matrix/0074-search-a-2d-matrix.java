class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int l = 0;
        int r = m - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int[] mat = matrix[mid];
            if(mat[0] <= target && mat[n - 1] >= target){
                ans = mid;
                break;
            }else if(mat[0] > target){
                r = mid - 1;
            }else l = mid + 1;
        }
        if(ans == -1) return false;;
        l = 0;
        r = n - 1;
        int[] mat = matrix[ans];
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mat[mid] == target) return true;
            else if(mat[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}