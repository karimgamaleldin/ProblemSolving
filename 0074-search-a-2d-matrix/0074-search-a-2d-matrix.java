class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int up = 0;
        int down = matrix.length - 1;
        int row = -1;
        while(up <= down){
            int mid = (up + down) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][n - 1]){
                row = mid;
                break;
            }else if(target > matrix[mid][n - 1]){
                up = mid + 1;
            }else{
                down = mid - 1;
            }
        }
        if(row == -1) return false;
        int[] arr = matrix[row];
        up = 0;
        down = n - 1;
        while(up <= down){
            int mid = (up + down) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] < target) up = mid + 1;
            else down = mid - 1;
        }
        return false;
    }
}