class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer , Integer> countGaps = new HashMap<>();
        int n = wall.size();
        for(int i = 0 ; i < n ; i++){
            List<Integer> list = wall.get(i);
            int m = list.size();
            int curr = 0;
            for(int j = 0 ; j < m - 1 ; j++){
                curr += list.get(j);
                countGaps.put(curr , countGaps.getOrDefault(curr , 0) + 1);
            }
        }
        int max = 0;
        for(int k : countGaps.values()) max = Math.max(max , k);
        return wall.size() - max;
    }
}