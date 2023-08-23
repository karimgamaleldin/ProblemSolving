class Solution {
    public String minWindow(String s, String t) {
        int m = s.length() , n = t.length();
        Map<Character , Integer> map1 = new HashMap<>();
        Map<Character , Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < n ; i++) map2.put(t.charAt(i) , map2.getOrDefault(t.charAt(i) , 0) + 1);
        int counts = 0;
        int j = 0;
        int distinct = map2.size();
        int ans = Integer.MAX_VALUE;
        String r = "";
        for(int i = 0 ; i < m ; i++){
            char x = s.charAt(i);
            map1.put(x , map1.getOrDefault(x , 0) + 1);
            if(map1.get(x).equals(map2.getOrDefault(x , -1))) counts++;
            while(counts == distinct){
                if(i - j + 1 < ans){
                    ans = i - j + 1;
                    r = s.substring(j , i + 1);
                }
                char c = s.charAt(j);
                map1.put(c , map1.get(c) - 1);
                if(map2.containsKey(c) && map1.get(c) < map2.get(c)){
                    counts--;
                }
                j++;
            }
        }
        // System.out.println(map1);
        // System.out.println(map1.get('a'));
        // System.out.println(map2.get('a'));
        // System.out.println(map2);
        // System.out.println(counts +" "+ distinct);
        return r;
    }
}