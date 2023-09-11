class Solution {
    public String minWindow(String s, String t) {
        int m = s.length() , n = t.length();
        Map<Character , Integer> map1 = new HashMap<>();
        Map<Character , Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < n ; i++) map2.put(t.charAt(i) , map2.getOrDefault(t.charAt(i) , 0) + 1);
        int l = 0;
        int r = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        int count = 0;
        while(r < m){
            char c = s.charAt(r);
            int x = map1.getOrDefault(c , 0) + 1;
            int y = map2.getOrDefault(c, -1);
            map1.put(c, x);
            if(x <= y) count++;
            while(count == n){
                if(r - l + 1 < min){
                    min = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                char d = s.charAt(l);
                if(map2.containsKey(d) && map1.get(d) <= map2.get(d)) count--;
                map1.put(d, map1.get(d) - 1);
                l++;
            }
            r++;
        }
        // System.out.println(map1);
        // System.out.println(map1.get('a'));
        // System.out.println(map2.get('a'));
        // System.out.println(map2);
        // System.out.println(counts +" "+ distinct);
        return ans;
    }
}