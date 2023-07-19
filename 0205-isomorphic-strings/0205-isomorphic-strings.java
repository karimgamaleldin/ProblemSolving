class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character , Character> map = new HashMap<Character , Character>();
        Map<Character , Character> map2 = new HashMap<Character , Character>();
        for(int i = 0 ; i < n ; i++){
            char x = s.charAt(i);
            char y = t.charAt(i);
            if(map.containsKey(x) && map.get(x) != y) return false;
            if(map2.containsKey(y) && map2.get(y) != x) return false;
            map.put(x , y);
            map2.put(y , x);
        }        
        return true;
    }
}