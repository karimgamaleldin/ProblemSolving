class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < 26 ; i++) map.put(order.charAt(i) , i);
        for(int i = 0 ; i < words.length - 1 ; i++){
            if(!compare(words[i] , words[i + 1] , map)) return false;
        }
        return true;
    }
    public boolean compare(String a , String b ,  HashMap<Character , Integer> map){
        int x = Math.min(a.length() , b.length());
        for(int i = 0 ; i < x ; i++){
            char c = a.charAt(i);
            char d = b.charAt(i);
            int e = map.get(c);
            int f = map.get(d);
            if(e < f) return true;
            if(e > f) return false;
        }
        if (b.length() < a.length()) return false;
        return true;
    }
}