class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> alph = new HashMap<>();
        int l = 0;
        int length = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            alph.put(c, alph.getOrDefault(c, 0) + 1);
            while(alph.get(c) == 2){
                char d = s.charAt(l++);
                alph.put(d, alph.get(d) - 1);
            }
            length = Math.max(length , i - l + 1);
        }
        return length;
    }
}