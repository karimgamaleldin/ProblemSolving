class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int k = 0;
        for(int i = 0 ; i < n - 1 ;i++){
            for(int j = i ; j < n - 1 - i ;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
                // System.out.println(i + " - " + j);
                // print(matrix);
                
            }
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