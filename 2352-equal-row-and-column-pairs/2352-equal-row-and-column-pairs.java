class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String , Integer> map = new HashMap<>();
        for(int i = 0 ; i < grid.length ; i++){
            String x = Arrays.toString(grid[i]);
            map.put(x , map.getOrDefault(x , 0) + 1);
        }
        int ans = 0;
        for(int i = 0 ; i < grid.length ; i++){
            int[] t = new int[grid.length];
            for(int j = 0 ; j < grid.length ; j++){
                t[j] = grid[j][i];
            }
            ans += map.getOrDefault(Arrays.toString(t) , 0);
        }
        return ans;
    }
}