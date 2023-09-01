class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            min = Math.min(min , arr[i+1] - arr[i]);
        }
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i+1]-arr[i] == min){
                List<Integer> r = new LinkedList<>();
                r.add(arr[i]);
                r.add(arr[i+1]);
                ans.add(r);
            }
        }
        return ans;
    }
}