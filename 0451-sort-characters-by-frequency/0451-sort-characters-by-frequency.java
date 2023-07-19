class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            char x = s.charAt(i);
            map.put(x , map.getOrDefault(x , 0) + 1);
        }
        List<Character> l =  new ArrayList<>(map.keySet());
        Collections.sort(l , (c1 , c2) ->{
            return map.get(c2) - map.get(c1);
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0  ; i < l.size() ; i++){
            char c = l.get(i);
            int x = map.get(c);
            for(int j = 0 ; j < x ; j++) sb.append(c);
        }
        return sb.toString();
    }
}