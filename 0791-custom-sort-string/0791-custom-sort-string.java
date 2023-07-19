class Solution {
    public String customSortString(String order, String s) {
        int n = s.length();
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1);
        StringBuilder sb = new StringBuilder();
        n = order.length();
        for(int i = 0 ; i < n ; i++){
            char c = order.charAt(i);
            int x = map.getOrDefault(c , 0);
            for(int j = 0 ; j < x ; j++){
                sb.append(c);
            }
            map.remove(c);
        }
        for(char c : map.keySet()){
            int x = map.get(c);
            for(int j = 0 ; j < x ; j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}