class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        int left = 0;
        int right = 0;
        for(; right < k ; right++){
            if(isVowel(s.charAt(right))) count++;
        }
        int maxCount = count;
        for(; right < n ; right++){
            if(isVowel(s.charAt(left))) count--;
            if(isVowel(s.charAt(right))) count++;
            maxCount = Math.max(count , maxCount);
            left++;
        }
        return maxCount;
    }
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}