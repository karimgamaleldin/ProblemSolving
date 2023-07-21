class Solution {
    public String minWindow(String s, String t){
        Map<Character , Integer> map1 = new HashMap<>();
        Map<Character , Integer> map2 = new HashMap<>();
        int m = s.length();
        int n = t.length();
        if(n > m) return "";
        for(int i = 0 ; i < n ; i++) map2.put(t.charAt(i) , map2.getOrDefault(t.charAt(i) , 0) + 1);
        int left = 0;
        int right = 0;
        int num = 0;
        int min = m;
        String r = "";
        while(left < m){
            if(num == n){
                if(right - left <= min){
                    r = s.substring(left , right);
                    min = right - left;
                }
                char c = s.charAt(left);
                if(map2.containsKey(c)){
                    if(map1.get(c) <= map2.get(c)){
                        num--;
                    }
                    map1.put(c , map1.get(c) - 1);
                }
                left++;
            }else{
                if(right >= m) break;
                char c = s.charAt(right);
                if(map2.containsKey(c)){
                    if(map1.getOrDefault(c , 0) < map2.get(c)) num++;
                    map1.put(c , map1.getOrDefault(c , 0) + 1);
                }
                right++;
            }
        }
        return r;
    }
}