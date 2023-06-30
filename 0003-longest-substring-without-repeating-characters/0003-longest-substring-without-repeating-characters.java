class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int left = 0;
        int maxSize = 0;
        for(int i = 0 ; i < s.length() ;i++){
            if(set.contains(s.charAt(i))){
                while(s.charAt(left) != s.charAt(i)) set.remove(s.charAt(left++));
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(i));
            maxSize = Math.max(i - left + 1, maxSize );
        }
        return maxSize;
    }
}