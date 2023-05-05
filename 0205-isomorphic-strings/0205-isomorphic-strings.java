class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character , Character > hash1 = new HashMap<Character , Character >();
        HashMap<Character , Character > hash2 = new HashMap<Character , Character >();
        
        for(int i = 0 ; i < s.length() ; i++){
            if(hash1.containsKey(s.charAt(i))){
                char x  = hash1.get(s.charAt(i));
                if ( x != t.charAt(i) ) return false;
            }
            if(hash2.containsKey(t.charAt(i))){
                char x  = hash2.get(t.charAt(i));
                if ( x != s.charAt(i) ) return false;
            }
            hash1.put(s.charAt(i) , t.charAt(i));
            hash2.put(t.charAt(i) , s.charAt(i));
        }
        return true;
    }
}