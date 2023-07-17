class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < nums[i].length ; j++){
                map.put(nums[i][j] , map.getOrDefault(nums[i][j] , 0) + 1);
            }
        }
        List<Integer> arr = new ArrayList<>();
        for(int x : map.keySet()){
            if(map.get(x) == n) arr.add(x);
        }
        Collections.sort(arr);
        return arr;
    }
}