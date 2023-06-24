class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character , String> map1 = new HashMap<Character , String>();
        HashMap<String , Character> map2 = new HashMap<String , Character>();
        String[] sr = s.split(" "); 
        if(pattern.length() != sr.length) return false;
        for(int i = 0 ; i < pattern.length() ; i++){
            if(map1.containsKey(pattern.charAt(i))){
                if(!map1.get(pattern.charAt(i)).equals(sr[i])) return false;
            }
            if(map2.containsKey(sr[i])){
                if(!(map2.get(sr[i]) == pattern.charAt(i))) return false;
            }
            map1.put(pattern.charAt(i) , sr[i]);
            map2.put(sr[i] , pattern.charAt(i));

        }
        return true;
              
        
    }
}