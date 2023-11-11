class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int k = 0;
        for(int i = k; i < n - k; i++){
            for(int j = k; j < n - k; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
            k++;
        }
        
    }
    public void print(int[][] matrix){
        for(int[] mat : matrix){
            for(int m : mat){
                System.out.print(m + " , ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
}