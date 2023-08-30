class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int dis = 0;
        int und = 0;
        int n = moves.length();
        for(int i = 0 ; i < n ; i++){
            char c = moves.charAt(i);
            if(c == 'R') dis++;
            else if(c == 'L') dis--;
            else und++;
        }
        return Math.max(Math.abs(dis + und) , Math.abs(dis - und));
    }
}