class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sol = 0;
        int left = 0;
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            int x = map.getOrDefault(c, 0);
            while(x == 1){
                char d = s.charAt(left++);
                if(c == d) x--;
                else map.remove(d);
            }
            map.put(c, 1);
            sol = Math.max(sol, i - left + 1);
        }
        return sol;
    }
}