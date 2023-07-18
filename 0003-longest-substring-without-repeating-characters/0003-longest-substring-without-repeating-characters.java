class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int ans = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) >= left) left = map.get(c) + 1;
            }
            map.put(c , i);
            ans = Math.max(ans , i - left + 1);
        }
        return ans;
    }
}