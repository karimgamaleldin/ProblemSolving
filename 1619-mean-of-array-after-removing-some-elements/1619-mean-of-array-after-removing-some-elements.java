class Solution {
    public double trimMean(int[] arr) {
        double sum = 0;
        int total = 0;
        Arrays.sort(arr);
        int fiveP = (int) (arr.length * 0.05);
        int n = arr.length;
        for(int i = fiveP; i < n - fiveP; i++){
            sum += arr[i];
            total++;
        }
        return sum / total;
    }
}