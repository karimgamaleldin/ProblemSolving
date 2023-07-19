class Solution {
    public boolean isPathCrossing(String path) {
        int n = path.length();
        HashSet<Pair<Integer , Integer>> set = new HashSet<>();
        Pair<Integer , Integer> pair = new Pair(0 , 0);
        set.add(pair);
        for(int i = 0 ; i < n ; i++){
            char c = path.charAt(i);
            int x = pair.getKey();
            int y = pair.getValue();
            if(c == 'N') y++;
            else if(c == 'S') y--;
            else if(c == 'W') x--;
            else x++;
            Pair<Integer , Integer> p = new Pair(x , y);
            if(set.contains(p)) return true;
            set.add(p);
            pair = p;
        }
        return false;
    }
}