class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        int left = 0;
        int right = 0;
        for(; right < k ; right++){
            count += isVowel(s.charAt(right));
        }
        int maxCount = count;
        for(; right < n ; right++){
            count += isVowel(s.charAt(right)) - isVowel(s.charAt(left++));
            maxCount = Math.max(count , maxCount);
        }
        return maxCount;
    }
    public int isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }
}