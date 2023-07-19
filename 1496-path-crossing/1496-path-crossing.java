class Solution {
    public boolean isPathCrossing(String path) {
        int n = path.length();
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(x + "," + y);
        for(int i = 0 ; i < n ; i++){
            char c = path.charAt(i);
            if(c == 'N') y++;
            else if(c == 'S') y--;
            else if(c == 'W') x--;
            else x++;
            String s = x + "," + y;
            if(set.contains(s)) return true;
            set.add(s);
        }
        return false;
    }
}