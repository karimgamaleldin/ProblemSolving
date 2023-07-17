class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        Map<Integer , int[]> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int[] curr = matches[i];
            if(!map.containsKey(curr[0])) map.put(curr[0] , new int[]{0,0});
            if(!map.containsKey(curr[1])) map.put(curr[1] , new int[]{0,0});
            map.get(curr[0])[0]++;
            map.get(curr[1])[1]++;
        }
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> allWinners = new ArrayList<>();
        List<Integer> lostOne = new ArrayList<>();
        for(int x : map.keySet()){
            int[] record = map.get(x);
            if(record[1] == 0) allWinners.add(x);
            if(record[1] == 1) lostOne.add(x);
        }
        Collections.sort(allWinners);
        Collections.sort(lostOne);
        r.add(allWinners);
        r.add(lostOne);
        return r;
    }
}