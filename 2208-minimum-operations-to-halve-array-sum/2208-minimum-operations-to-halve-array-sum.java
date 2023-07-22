class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(double num : nums){
            sum += num;
            pq.add(num);
        }
        double currSum = sum;
        int ans = 0;
        while(currSum > sum / 2){
            ans++;
            double x = pq.remove();
            currSum -= x / 2 ;
            pq.add(x / 2);
        }
        return ans;
    }
}