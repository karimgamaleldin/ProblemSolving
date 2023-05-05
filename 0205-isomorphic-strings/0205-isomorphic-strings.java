class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character , Character > hash1 = new HashMap<Character , Character >();
        HashMap<Character , Character > hash2 = new HashMap<Character , Character >();
        
        for(int i = 0 ; i < s.length() ; i++){
            // if(hash1.containsKey(s.charAt(i))){ to be faster
            //     char x  = hash1.get(s.charAt(i));
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if ( hash1.getOrDefault(sc , tc) != tc)  return false;
            // }
            // if(hash2.containsKey(t.charAt(i))){
            //    char x  = hash2.get(t.charAt(i));
            if ( hash2.getOrDefault(tc , sc) != sc)  return false;
            // }
            hash1.put(sc , tc);
            hash2.put(tc , sc);
        }
        return true;
    }
}