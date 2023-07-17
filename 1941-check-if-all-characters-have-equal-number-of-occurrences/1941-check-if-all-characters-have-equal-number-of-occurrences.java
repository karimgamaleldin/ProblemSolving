class Solution {
    public boolean areOccurrencesEqual(String s) {
        int n = s.length();
        Map<Character , Integer> map = new HashMap<Character , Integer>();
        for(int i = 0 ; i < n ; i++){
            char x = s.charAt(i);
            map.put(x , map.getOrDefault(x , 0) + 1);
        }
        int count = map.get(s.charAt(0));
        for(int x : map.values()){
            if(count != x) return false;
        }
        return true;
    }
}